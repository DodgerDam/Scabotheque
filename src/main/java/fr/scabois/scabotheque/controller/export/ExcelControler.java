package fr.scabois.scabotheque.controller.export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContactRole;
import fr.scabois.scabotheque.controller.adherent.CriteriaAdherent;
import fr.scabois.scabotheque.services.IServiceAdherent;
import fr.scabois.scabotheque.utils.AppProperties;

@Controller
public class ExcelControler {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping("/downloadFile")
    public void downloadFile(@RequestParam(value = "findText") final String findText,
	    @RequestParam(value = "poleId") final int poleId, @RequestParam(value = "secteurId") final int secteurId,
	    @RequestParam(value = "showAll") final Boolean showAll, HttpServletRequest request,
	    HttpServletResponse response) {

	try {

	    AppProperties.getPropertie("export.template.excel");

	    CriteriaAdherent criteria = new CriteriaAdherent();
	    criteria.setText(findText);
	    criteria.setPoleId(poleId);
	    criteria.setSecteurId(secteurId);
	    criteria.setShowAll(showAll);

	    List<Adherent> listAdh = service.LoadAdherents(criteria);

	    String fileName = AppProperties.getPropertie("export.path") + "/ListAdhernet"
		    + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + ".xlsx";

	    XSSFWorkbook workBook = openExcelWorkBook();
	    XSSFSheet sheet = openSheet(workBook);

	    final AtomicInteger cpt = new AtomicInteger();
	    listAdh.stream().forEach(a -> {
		AdherentContactRole contact = a.getContacts().stream().filter(c -> c.getFonction().getId().equals(1))
			.findFirst().get();

		XSSFRow row = sheet.createRow(cpt.incrementAndGet());
		row.createCell(0).setCellValue(a.getCodeERP());
		row.createCell(1).setCellValue(contact == null ? "" : contact.getNom());
		row.createCell(2).setCellValue(contact == null ? "" : contact.getPrenom());
		row.createCell(4).setCellValue(a.getSiren());
		row.createCell(4).setCellValue(a.getDenomination());
		row.createCell(5).setCellValue(a.getAdresse());
		row.createCell(6).setCellValue(a.getCommune() == null ? "" : a.getCommune().getCodePostal());
		row.createCell(7).setCellValue(a.getCommune() == null ? "" : a.getCommune().getLibelle());
		row.createCell(8).setCellValue(a.getAgence().getLibelle());
		row.createCell(9).setCellValue("");

	    });

	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    workBook.write(fileOut);
	    fileOut.close();

	    // Chargement et Download du fichier
	    File fileToDownload = new File(fileName);
	    InputStream in = new FileInputStream(fileToDownload);

	    // MIME type
	    String mimeType = new MimetypesFileTypeMap().getContentType(fileName);

	    if (mimeType == null) {
		// Set to binary type if MIME mapping not found
		mimeType = "application/octet-stream";
	    }

	    // Modification de la response
	    response.setContentType(mimeType);
	    response.setContentLength((int) fileToDownload.length());

	    // Force le download
	    String headerKey = "Content-Disposition";
	    String headerValue = String.format("attachment; filename=\"%s\"", fileToDownload.getName());
	    response.setHeader(headerKey, headerValue);

	    OutputStream outStream = response.getOutputStream();

	    byte[] buffer = new byte[4096];
	    int bytesRead = -1;

	    while ((bytesRead = in.read(buffer)) != -1) {
		outStream.write(buffer, 0, bytesRead);
	    }

	    in.close();
	    outStream.close();

	    // Suppression du fichier sur le disque
	    fileToDownload.delete();

	} catch (Exception ex) {
	    System.out.println(ex);
	}
    }

    private XSSFWorkbook openExcelWorkBook() {

	// test ouverture fichier template.
	XSSFWorkbook workBook;
	try {
	    workBook = new XSSFWorkbook(AppProperties.getPropertie("export.template.excel"));

	} catch (InvalidOperationException | IOException i) {
	    // Le fichier n'exist pas
	    workBook = new XSSFWorkbook();
	}

	return workBook;
    }

    private XSSFSheet openSheet(XSSFWorkbook workBook) {

	// essaye d'ouvrir la feuille de calcul duclasseur Excel
	XSSFSheet sheet = workBook.getSheet("Adherents");

	// si pas d feuille -> création.
	if (sheet == null) {
	    sheet = workBook.createSheet("Adherents");

	    XSSFRow rowhead = sheet.createRow((short) 0);
	    rowhead.createCell(0).setCellValue("Code");
	    rowhead.createCell(1).setCellValue("Nom");
	    rowhead.createCell(2).setCellValue("Prenom");
	    rowhead.createCell(3).setCellValue("SIREN");
	    rowhead.createCell(4).setCellValue("Adherent");
	    rowhead.createCell(5).setCellValue("Adresse");
	    rowhead.createCell(6).setCellValue("Code Postal");
	    rowhead.createCell(7).setCellValue("Ville");
	    rowhead.createCell(8).setCellValue("Agence");
	    rowhead.createCell(9).setCellValue("Commentaire");
	}

	return sheet;
    }
}
