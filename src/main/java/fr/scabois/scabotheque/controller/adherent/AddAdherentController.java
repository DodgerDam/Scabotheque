package fr.scabois.scabotheque.controller.adherent;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.scabois.scabotheque.bean.Adherent;
import fr.scabois.scabotheque.bean.Agence;
import fr.scabois.scabotheque.bean.Ape;
import fr.scabois.scabotheque.bean.Etat;
import fr.scabois.scabotheque.bean.FormeJuridique;
import fr.scabois.scabotheque.bean.Pole;
import fr.scabois.scabotheque.bean.Role;
import fr.scabois.scabotheque.bean.Secteur;
import fr.scabois.scabotheque.bean.Tournee;
import fr.scabois.scabotheque.controller.adherent.edit.EditAdherent;
import fr.scabois.scabotheque.controller.adherent.edit.EditAdherentForm;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class AddAdherentController {

    @Autowired
    private IServiceAdherent service;
    private EditAdherent adhEditable;

    @RequestMapping(value = "/addAdherent", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {

	addSelectLists(pModel);

	if (pModel.get("adhToEdit") == null) {
//	if (adhEditable == null) {

//	    final Adherent adh = service.LoadAdherent(idAdh);
	    final EditAdherentForm editAdhForm = new EditAdherentForm();

	    // Rend l'adherent éditable (avec des validations test)
	    EditAdherent editableAdh = new EditAdherent(); // adhToEdit(adh);
	    editAdhForm.setAdherent(editableAdh);

	    pModel.addAttribute("adhToEdit", editAdhForm);
	} else {
	    pModel.addAttribute("adhToEdit", pModel.get("adhToEdit"));
	}

	pModel.addAttribute("pageType", PageType.CREATE_ADHERENT);

	return "addAdh";
    }

    @RequestMapping(value = "/addAdherent", method = RequestMethod.POST)
    public String modifier(@Valid @ModelAttribute(value = "adhToAdd") final EditAdherentForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	adhEditable = editForm.getAdherent();
	Adherent adh = editToAdh(adhEditable);

	if (!pBindingResult.hasErrors()) {
	    service.saveAdherent(adh);
	}

	// voir retour direct à la liste
	return afficher(pModel);
    }

    private void addSelectLists(final ModelMap pModel) {
	List<Agence> agences = service.LoadAgences();
	List<Ape> codeApes = service.LoadCodeApes();
	List<Etat> etats = service.LoadEtats();
	List<FormeJuridique> formesJuridiques = service.LoadFormesJuridiques();
	List<Pole> poles = service.LoadPoles();
	List<Role> roles = service.LoadRoles();
	List<Secteur> secteurs = service.LoadSecteurs();
	List<Tournee> tournees = service.LoadTournees();

	pModel.addAttribute("agenceList", agences);
	pModel.addAttribute("apeList", codeApes);
	pModel.addAttribute("etatList", etats);
	pModel.addAttribute("formJuridList", formesJuridiques);
	pModel.addAttribute("poleList", poles);
	pModel.addAttribute("roleList", roles);
	pModel.addAttribute("secteurList", secteurs);
	pModel.addAttribute("tourneeList", tournees);

    }

    public Adherent editToAdh(EditAdherent editAdh) {
	final Adherent adh = new Adherent();

	adh.setId(editAdh.getId());
	adh.setCode(editAdh.getCode());
	adh.setLibelle(editAdh.getLibelle());
	adh.setDenomination(editAdh.getDenomination());
	adh.setFormeJuridique(editAdh.getFormeJuridique());
	adh.setDateEntree(editAdh.getDateEntree());
	adh.setAdresse(editAdh.getAdresse());
	adh.setAdresseComplement(editAdh.getAdresseComplement());
	adh.setCommune(editAdh.getCommune());
	adh.setPole(editAdh.getPole());
	adh.setRole(editAdh.getRole());
	adh.setSecteur(editAdh.getSecteur());
	adh.setIsArtipole(editAdh.getIsArtipole());
	adh.setIsCharteArtipole(editAdh.getIsCharteArtipole());
	adh.setIsFlocageArtipole(editAdh.getIsFlocageArtipole());
	adh.setIsWebArtipole(editAdh.getIsWebArtipole());
	adh.setIsFormationCommerce(editAdh.getIsFormationCommerce());
	adh.setIsFacebookArtipole(editAdh.getIsFacebookArtipole());
	adh.setApe(editAdh.getApe());
	adh.setSiren(editAdh.getSiren());
	adh.setSiret(editAdh.getSiret());
	adh.setNumRepMetier(editAdh.getNumRepMetier());
	adh.setRcsRm(editAdh.getRcsRm());
	adh.setRcsCommune(editAdh.getRcsCommune());
	adh.setAgence(editAdh.getAgence());
	adh.setDateClotureExe(editAdh.getDateClotureExe());
	adh.setTournee(editAdh.getTournee());
	adh.setOutilDechargement(editAdh.getIsOutilDechargement());
	adh.setContactComptable(editAdh.getContactComptable());
	adh.setEtat(editAdh.getEtat());

	return adh;
    }

    public EditAdherent adhToEdit(Adherent adh) {
	final EditAdherent editableAdh = new EditAdherent();

	editableAdh.setId(adh.getId());
	editableAdh.setCode(adh.getCode());
	editableAdh.setLibelle(adh.getLibelle());
	editableAdh.setDenomination(adh.getDenomination());
	editableAdh.setFormeJuridique(adh.getFormeJuridique());
	editableAdh.setDateEntree(adh.getDateEntree());
	editableAdh.setAdresse(adh.getAdresse());
	editableAdh.setAdresseComplement(adh.getAdresseComplement());
	editableAdh.setCommune(adh.getCommune());
	editableAdh.setPole(adh.getPole());
	editableAdh.setRole(adh.getRole());
	editableAdh.setSecteur(adh.getSecteur());
	editableAdh.setIsArtipole(adh.getIsArtipole());
	editableAdh.setIsCharteArtipole(adh.getIsCharteArtipole());
	editableAdh.setIsFlocageArtipole(adh.getIsFlocageArtipole());
	editableAdh.setIsWebArtipole(adh.getIsWebArtipole());
	editableAdh.setIsFormationCommerce(adh.getIsFormationCommerce());
	editableAdh.setIsFacebookArtipole(adh.getIsFacebookArtipole());
	editableAdh.setApe(adh.getApe());
	editableAdh.setSiren(adh.getSiren());
	editableAdh.setSiret(adh.getSiret());
	editableAdh.setNumRepMetier(adh.getNumRepMetier());
	editableAdh.setRcsRm(adh.getRcsRm());
	editableAdh.setRcsCommune(adh.getRcsCommune());
	editableAdh.setAgence(adh.getAgence());
	editableAdh.setDateClotureExe(adh.getDateClotureExe());
	editableAdh.setTournee(adh.getTournee());
	editableAdh.setIsOutilDechargement(adh.getIsOutilDechargement());
	editableAdh.setContactComptable(adh.getContactComptable());
	editableAdh.setEtat(adh.getEtat());

	return editableAdh;
    }

}
