package fr.scabois.scabotheque.controller.adherent;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContact;
import fr.scabois.scabotheque.bean.commun.TypeContact;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class ShowAdherentController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/adherentActivite", "/adherentAdministratif", "/adherentExploitation",
	    "/adherentDetail" }, method = RequestMethod.GET)
    public String afficher(@RequestParam(value = "idAdh") final int idAdh, final ModelMap pModel,
	    HttpServletRequest request) {

	final Adherent adherent = service.LoadAdherent(idAdh);

	PageType pageType = PageType.LIST_ADHERENT;
	switch (request.getServletPath().substring(1)) {
	case "adherentActivite":
	    pageType = PageType.ADHERENT_ACTIVITE;
	    break;
	case "adherentAdministratif":
	    pageType = PageType.ADHERENT_ADMINISTRATIF;
	    break;
	case "adherentExploitation":
	    pageType = PageType.ADHERENT_EXPLOITATION;
	    break;
	case "adherentDetail":
	    final Map<TypeContact, AdherentContact> contacts = service.LoadAdherentContact(idAdh);
	    pModel.addAttribute("mapContact", contacts);
	    pageType = PageType.ADHERENT_DETAIL;
	    break;
	default:
	    pageType = PageType.LIST_ADHERENT;

	}

	pModel.addAttribute("pageType", pageType);

	pModel.addAttribute("adherent", adherent);

	return request.getServletPath().substring(1);
    }

}
