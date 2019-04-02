package fr.scabois.scabotheque.controller.adherent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.Adherent;
import fr.scabois.scabotheque.bean.Pole;
import fr.scabois.scabotheque.bean.Secteur;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
//@RestController
@RequestMapping(value = { "/", "/listeAdherents" })
public class ListeAdherentsController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(method = RequestMethod.GET)
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
	    pModel.addAttribute("listeAdherents", listeAdherents);
	}

	pModel.addAttribute("pageType", PageType.LIST_ADHERENT);

	return "listeAdh";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String rechercher(ModelMap pModel, @RequestParam("findString") final String recherche,
	    @RequestParam("pole") final Integer poleId, @RequestParam("secteur") final Integer secteurId) {

	final List<Adherent> listeAdherents = service.LoadAdherents();

	// filtre la liste des adherents sur les libellés
	List<Adherent> filterList = listeAdherents.stream().filter(adh -> {
	    boolean isLib = adh.getLibelle().toUpperCase().contains(recherche.toUpperCase());
	    boolean isCode = adh.getCode().toUpperCase().contains(recherche.toUpperCase());
	    boolean isDenom = adh.getDenomination() == null ? false
		    : adh.getDenomination().toUpperCase().contains(recherche.toUpperCase());
	    boolean isPole = adh.getPole().getId() == poleId;

	    return isLib || isDenom || isCode || isPole;
	}).collect(Collectors.toList());

	// renvois la liste des adherents filtré sur le pole
	pModel.addAttribute("listeAdherents",
		filterList.stream().filter(adh -> poleId == 0 || adh.getPole().getId() == poleId)
			.filter(adh -> secteurId == 0 || adh.getSecteur().getId() == secteurId)
			.collect(Collectors.toList()));

	return afficher(pModel);
    }
}
