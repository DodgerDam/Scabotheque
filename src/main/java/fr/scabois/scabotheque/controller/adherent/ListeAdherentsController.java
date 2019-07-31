package fr.scabois.scabotheque.controller.adherent;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.Pole;
import fr.scabois.scabotheque.bean.adherent.Secteur;
import fr.scabois.scabotheque.bean.commun.ContactFonction;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.ApplicationMailer;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class ListeAdherentsController {

    @Autowired
    public ApplicationMailer mailer;
    private String msg = "";

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/", "/listeAdherents" }, method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {

	// Chargement des listes de recherche rapide
	// List<Metier> adhMetier = service.LoadMetiersAdherents();
	List<Pole> poles = service.LoadPoles();
	List<Secteur> secteurs = service.LoadSecteurs();
	List<ContactFonction> contactFonctions = service.LoadContactFonctions();

	// pModel.addAttribute("adhMetierList", adhMetier);
	pModel.addAttribute("polesList", poles);
	pModel.addAttribute("secteursList", secteurs);
	pModel.addAttribute("contactFonctionList", contactFonctions);

	// Si on arrive de la requestMethode POST
	if (pModel.get("listeAdherents") == null) {
	    // filtre en même temps sur les actifs
	    List<Adherent> listeAdherents = service.LoadAdherents().stream().filter(a -> a.getEtat().getId() == 1)
		    .sorted(Comparator.comparing(Adherent::getLibelle)).collect(Collectors.toList());
	    pModel.addAttribute("listeAdherents", listeAdherents);

	    final CriteriaAdherent criteria = new CriteriaAdherent();
	    criteria.setAdherentIds(listeAdherents.stream().map(m -> m.getCode()).collect(Collectors.toList()));
	    pModel.addAttribute("criteria", criteria);
	}

	pModel.addAttribute("pageType", PageType.LIST_ADHERENT);

	return "listeAdh";
    }

    @RequestMapping(value = { "/", "/listeAdherents" }, method = RequestMethod.POST)
    public String modifieAdh(@ModelAttribute(value = "criteria") final CriteriaAdherent criteria,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	final List<Adherent> listeAdherents = service.LoadAdherents(criteria);

	pModel.addAttribute("listeAdherents", listeAdherents);
	criteria.setAdherentIds(listeAdherents.stream().map(m -> m.getCode()).collect(Collectors.toList()));

	return afficher(pModel);
    }

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendMail(@ModelAttribute(value = "criteria") final CriteriaAdherent criteria,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	try {
	    mailer.sendHTMLMail(criteria.getSender(), "adrien.fort@scabois.fr", criteria.getObject(),
		    criteria.getMessageMail() + criteria.getAdherentIds().toString());
	    criteria.setAvertissement("Votre message est envoyé.");

	} catch (Exception e) {
	    criteria.setAvertissement("Une erreur est survenue, Le message na pas été envoyé.");
	}

//	return modifieAdh(criteria, pBindingResult, pModel, request);

	final List<Adherent> listeAdherents = service.LoadAdherents(criteria);

	pModel.addAttribute("listeAdherents", listeAdherents);
	criteria.setAdherentIds(listeAdherents.stream().map(m -> m.getCode()).collect(Collectors.toList()));

	return afficher(pModel);
    }
}
