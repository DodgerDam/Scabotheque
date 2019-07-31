package fr.scabois.scabotheque.controller.adherent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContactRole;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class ShowAdherentController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/adherentActivite", "/adherentArtipole", "/adherentAdministratif",
	    "/adherentExploitation", "/adherentInformatique", "/adherentDetail" }, method = RequestMethod.GET)
    public String afficher(@RequestParam(value = "idAdh") final int idAdh, final ModelMap pModel,
	    HttpServletRequest request) {

	String commentaire = "";
	final Adherent adherent = service.LoadAdherent(idAdh);

	PageType pageType = PageType.LIST_ADHERENT;
	switch (request.getServletPath().substring(1)) {
	case "adherentActivite":
	    pageType = PageType.ADHERENT_ACTIVITE;
	    break;
	case "adherentArtipole":
	    pageType = PageType.ADHERENT_ARTIPOLE;
	    break;
	case "adherentAdministratif":
	    pageType = PageType.ADHERENT_ADMINISTRATIF;
	    break;
	case "adherentExploitation":
	    pageType = PageType.ADHERENT_EXPLOITATION;
	    break;
	case "adherentInformatique":
	    pageType = PageType.ADHERENT_INFORMATIQUE;
	    break;
	case "adherentDetail":
	    final List<AdherentContactRole> contacts = service.LoadAdherentContact(idAdh);
	    pModel.addAttribute("contacts", contacts);
	    pageType = PageType.ADHERENT_DETAIL;
	    break;
	default:
	    pageType = PageType.LIST_ADHERENT;
	}

	commentaire = service.LoadAdherentCommentaire(idAdh, pageType);
	pModel.addAttribute("pageType", pageType);

	pModel.addAttribute("commentaire", commentaire);
	pModel.addAttribute("adherent", adherent);

	return request.getServletPath().substring(1);
    }

}
