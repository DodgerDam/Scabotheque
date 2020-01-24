package fr.scabois.scabotheque.services;

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
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContactRole;
import fr.scabois.scabotheque.controller.adherent.CriteriaAdherent;
import fr.scabois.scabotheque.utils.AppProperties;

@Service("exportService")
public class ExportService {

    @Autowired
    private IServiceAdherent service;

    public void downloadFile(CriteriaAdherent criteria, HttpServletResponse response) {
	try {

	    AppProperties.getPropertie("export.template.excel");

	    List<Adherent> listAdh = service.LoadAdherents(criteria);

	    String fileName = AppProperties.getPropertie("export.path") + "/"
		    + AppProperties.getPropertie("export.fileName") + LocalDate.now().format(DateTimeFormatter.ISO_DATE)
		    + ".xlsx";

	    XSSFWorkbook workBook = openExcelWorkBook();
	    XSSFSheet sheet = openSheet(workBook, listAdh.size());

	    final AtomicInteger cpt = new AtomicInteger(1);
	    listAdh.stream().forEach(a -> {
		// recherche des
//		System.out.println(a.getLibelle());
		AdherentContactRole contact = a.getContacts().stream().filter(c -> c.getFonction().getId().equals(1))
			.findFirst().orElse(null);

		XSSFRow row = sheet.createRow(cpt.getAndIncrement());
		row.createCell(0).setCellValue(a.getCodeERP());
		row.createCell(1).setCellValue(contact == null ? "" : contact.getNom());
		row.createCell(2).setCellValue(contact == null ? "" : contact.getPrenom());
		row.createCell(3).setCellValue(a.getSiren());
//		row.createCell(4).setCellValue(a.getFormeJuridique().getLibelle() + " " + a.getDenomination());
		row.createCell(4).setCellValue(a.getDenomination());
		row.createCell(5).setCellValue(a.getAdresse());
		row.createCell(6).setCellValue(a.getAdresseComplement());
		row.createCell(7).setCellValue(a.getCommune() == null ? "" : a.getCommune().getCodePostal());
		row.createCell(8).setCellValue(a.getCommune() == null ? "" : a.getCommune().getLibelle());
		row.createCell(9).setCellValue(a.getAgence().getLibelle());
		row.createCell(10).setCellValue(a.getEtat().getLibelle());
		row.createCell(11).setCellValue(contact == null ? "" : contact.getFixe());
		row.createCell(12).setCellValue(contact == null ? "" : contact.getMail());
		row.createCell(13).setCellValue("");
	    });

	    // Mise � jour du tableau
	    AreaReference tableArea = workBook.getCreationHelper().createAreaReference(new CellReference("A1"),
		    new CellReference("M" + cpt.get()));

	    XSSFTable table = workBook.getTable("ListeAdherents");
	    table.setArea(tableArea);

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
	    System.err.println("Erreur: " + ex.getMessage());
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

//    private XSSFSheet openSheet(XSSFWorkbook workBook) {
    private XSSFSheet openSheet(XSSFWorkbook workBook, int size) {

	// essaye d'ouvrir la feuille de calcul duclasseur Excel
	XSSFSheet sheet = workBook.getSheet("Adherents");

	// si pas d feuille -> cr�ation.
	if (sheet == null) {
	    sheet = workBook.createSheet("Adherents");

	    XSSFRow rowhead = sheet.createRow((short) 0);
	    rowhead.createCell(0).setCellValue("Code");
	    rowhead.createCell(1).setCellValue("Nom");
	    rowhead.createCell(2).setCellValue("Prenom");
//	    rowhead.createCell(3).setCellValue("SIREN");
	    rowhead.createCell(4).setCellValue("Adherent");
	    rowhead.createCell(5).setCellValue("Adresse");
	    rowhead.createCell(5).setCellValue("Complement d'adresse");
	    rowhead.createCell(6).setCellValue("Code Postal");
	    rowhead.createCell(7).setCellValue("Ville");
	    rowhead.createCell(8).setCellValue("Agence");
	    rowhead.createCell(9).setCellValue("Actif");
	    rowhead.createCell(10).setCellValue("Telephone");
	    rowhead.createCell(11).setCellValue("Messagerie");
	    rowhead.createCell(12).setCellValue("Commentaire");

	    AreaReference tableArea = workBook.getCreationHelper().createAreaReference(new CellReference("A2"),
		    new CellReference("M3"));

	    XSSFTable table = sheet.createTable(tableArea);
	    table.setDisplayName("ListeAdherents");
	    table.setName("ListeAdherents");
	    table.setStyleName("TableStyleMedium16");
	}

	return sheet;
    }
}