package fr.scabois.scabotheque.controller.adherent;

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
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class ListeAdherentsController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/", "/listeAdherents" }, method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {

	// Chargement des listes de recherche rapide
	// List<Metier> adhMetier = service.LoadMetiersAdherents();
	List<Pole> poles = service.LoadPoles();
	List<Secteur> secteurs = service.LoadSecteurs();

	// pModel.addAttribute("adhMetierList", adhMetier);
	pModel.addAttribute("polesList", poles);
	pModel.addAttribute("secteursList", secteurs);

	// Si on arrive de la requestMethode POST
	if (pModel.get("listeAdherents") == null) {
	    final List<Adherent> listeAdherents = service.LoadAdherents();
	    // ajout filtre sur les actifs
	    pModel.addAttribute("listeAdherents",
		    listeAdherents.stream().filter(a -> a.getEtat().getId() == 1).collect(Collectors.toList()));

	    final CriteriaAdherent criteria = new CriteriaAdherent();
	    pModel.addAttribute("criteria", criteria);
	}

	pModel.addAttribute("pageType", PageType.LIST_ADHERENT);

	return "listeAdh";
    }

    @RequestMapping(value = { "/", "/listeAdherents" }, method = RequestMethod.POST)
    public String modifieAdh(@ModelAttribute(value = "criteria") final CriteriaAdherent criteria,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	final List<Adherent> listeAdherents = service.LoadAdherents(criteria);

//	// filtre la liste des adherents sur les libellés
//	List<Adherent> filterList = listeAdherents.stream().filter(adh -> {
//	    boolean isLib = adh.getLibelle().toUpperCase().contains(criteria.getText().toUpperCase());
//	    boolean isCode = adh.getCode().toUpperCase().contains(criteria.getText().toUpperCase());
//	    boolean isDenom = adh.getDenomination() == null ? false
//		    : adh.getDenomination().toUpperCase().contains(criteria.getText().toUpperCase());
//	    boolean isPole = criteria.getPoleId() == 0 ? true : adh.getPole().getId().equals(criteria.getPoleId());
//	    boolean isSecteur = criteria.getSecteurId() == 0 ? true
//		    : adh.getSecteur().getId().equals(criteria.getSecteurId());
//	    boolean isActif = criteria.getIsActif() ? true : adh.getEtat().getId() == 1;
//
//	    return (isLib || isDenom || isCode) && isPole && isSecteur && isActif;
//	}).collect(Collectors.toList());

	pModel.addAttribute("listeAdherents", listeAdherents);
	// renvois la liste des adherents filtré sur le pole
//	pModel.addAttribute("listeAdherents", filterList.stream()
//		.filter(adh -> criteria.getPole().getId() == 0 || adh.getPole().getId() == criteria.getPole().getId())
//		.filter(adh -> criteria.getSecteur().getId() == 0
//			|| adh.getSecteur().getId() == criteria.getSecteur().getId())
//		.collect(Collectors.toList()));

	return afficher(pModel);
    }
}
