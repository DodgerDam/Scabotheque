package fr.scabois.scabotheque.controller.adherent.edit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContact;
import fr.scabois.scabotheque.bean.adherent.Etat;
import fr.scabois.scabotheque.bean.adherent.FormeJuridique;
import fr.scabois.scabotheque.bean.adherent.Pole;
import fr.scabois.scabotheque.bean.adherent.Role;
import fr.scabois.scabotheque.bean.adherent.Secteur;
import fr.scabois.scabotheque.bean.adherent.Tournee;
import fr.scabois.scabotheque.bean.commun.Agence;
import fr.scabois.scabotheque.bean.commun.Ape;
import fr.scabois.scabotheque.bean.commun.TypeContact;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class EditAdhController {

    @Autowired
    private IServiceAdherent service;

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

    private List<EditAdherentContact> adhContactToEdit(List<TypeContact> types, Adherent adherent) {
	final List<EditAdherentContact> ret = new ArrayList<>();

	// pour tous les type de contact
	types.stream().forEach(t -> {
	    // recherche si le contact exist
	    Optional<AdherentContact> optionalContact = adherent.getContacts().stream()
		    .filter(f -> f.getType().getId() == (t.getId())).findFirst();

	    EditAdherentContact edit = new EditAdherentContact();
	    // si il exist,, il faut le rendre editable
	    if (optionalContact.isPresent()) {
		edit.setAdherentId(optionalContact.get().getAdherent().getId());
		edit.setFixe(optionalContact.get().getFixe());
		edit.setId(optionalContact.get().getId());
		edit.setMail(optionalContact.get().getMail());
		edit.setMobile(optionalContact.get().getMobile());
		edit.setNom(optionalContact.get().getNom());
		edit.setNaissance(optionalContact.get().getNaissance());
		edit.setPhoto(optionalContact.get().getPhoto());
		edit.setPrenom(optionalContact.get().getPrenom());
		edit.setType(optionalContact.get().getType());
		edit.setTypeContactId(optionalContact.get().getType().getId());
	    } else {
		edit.setAdherentId(adherent.getId());
		edit.setType(t);
		edit.setTypeContactId(t.getId());
	    }
	    ret.add(edit);
	});
	return ret;
    }

    public EditAdherent adhToEdit(Adherent adh) {
	final EditAdherent editableAdh = new EditAdherent();

	editableAdh.setId(adh.getId());
	editableAdh.setCode(adh.getCode());
	editableAdh.setCodeERP(adh.getCodeERP());
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

    @RequestMapping(value = { "/edit/editActiviteAdh", "/edit/editAdministratifAdh", "/edit/editExploitationAdh",
	    "/edit/editIdentiteAdh" }, method = RequestMethod.GET)
    public String editAdherent(@RequestParam(value = "idAdh") final int idAdh, final ModelMap pModel,
	    HttpServletRequest request) {

	addSelectLists(pModel);

	if (pModel.get("adhToEdit") == null) {

	    final Adherent adh = service.LoadAdherent(idAdh);
	    final EditAdherentForm editAdhForm = new EditAdherentForm();

	    // Rend l'adherent éditable (avec des validations test)
	    EditAdherent editableAdh = adhToEdit(adh);
	    editAdhForm.setAdherent(editableAdh);

	    pModel.addAttribute("adhToEdit", editAdhForm);
	} else {
	    pModel.addAttribute("adhToEdit", pModel.get("adhToEdit"));
	}

	pModel.addAttribute("pageType", PageType.LIST_ADHERENT);

	// Implique que le nom des Tiles soit correctement alimenté
	return request.getServletPath().substring(6);
    }

    @RequestMapping(value = "/edit/editAdherentContact", method = RequestMethod.GET)
    public String editContact(@RequestParam(value = "idAdh") final int idAdh, final ModelMap pModel,
	    HttpServletRequest request) {

	addSelectLists(pModel);

	final Adherent adh = service.LoadAdherent(idAdh);
	final List<TypeContact> typeContacts = service.LoadTypeContact();
	pModel.addAttribute("adherent", adh);
	pModel.addAttribute("typeContacts", typeContacts);

	if (pModel.get("contactToEdit") == null) {

	    final EditAdherentContactsForm editAdhContactsForm = new EditAdherentContactsForm();

	    // Rend les contacts adhernet éditable (avec des validations test)
	    List<EditAdherentContact> editableAdhContacts = adhContactToEdit(typeContacts, adh);
	    editAdhContactsForm.setAdherentContacts(editableAdhContacts);

	    pModel.addAttribute("contactToEdit", editAdhContactsForm);
	} else {
	    pModel.addAttribute("contactToEdit", pModel.get("contactToEdit"));
	}

	pModel.addAttribute("pageType", PageType.LIST_ADHERENT);

	return "editContactAdh";
    }

    public Adherent editToAdh(EditAdherent editAdh) {
	final Adherent adh = new Adherent();

	adh.setId(editAdh.getId());
	adh.setCode(editAdh.getCode());
	adh.setCodeERP(editAdh.getCodeERP());
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

    private List<AdherentContact> editToContact(List<EditAdherentContact> adhContactEditable) {
	List<TypeContact> types = service.LoadTypeContact();
	List<AdherentContact> contacts = new ArrayList<>();

	adhContactEditable.stream().forEach(e -> {
	    AdherentContact contact = new AdherentContact();

	    contact.setAdherent(service.LoadAdherent(e.getAdherentId()));
	    contact.setType(types.stream().filter(t -> t.getId() == e.getTypeContactId()).findFirst().orElse(null));
	    contact.setCivilite(e.getCivilite());
	    contact.setFixe(e.getFixe());
	    contact.setId(e.getId());
	    contact.setMail(e.getMail());
	    contact.setMobile(e.getMobile());
	    contact.setNom(e.getNom());
	    contact.setNaissance(e.getNaissance());
	    contact.setPhoto(e.getPhoto());
	    contact.setPrenom(e.getPrenom());

	    contacts.add(contact);
	});

	return contacts;
    }

    @RequestMapping(value = { "/edit/editActiviteAdh", "/edit/editAdministratifAdh", "/edit/editExploitationAdh",
	    "/edit/editIdentiteAdh" }, method = RequestMethod.POST)
    public String modifieAdh(@Valid @ModelAttribute(value = "adhToEdit") final EditAdherentForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	EditAdherent adhEditable = editForm.getAdherent();
	Adherent adh = editToAdh(adhEditable);

	if (!pBindingResult.hasErrors()) {
	    service.saveAdherent(adh);
	    return "redirect:/adherentDetail?idAdh=" + adh.getId();
	}

	return editAdherent(editForm.getAdherent().getId(), pModel, request);
    }

    @RequestMapping(value = "/edit/editAdherentContact", method = RequestMethod.POST)
    public String modifieContact(
	    @Valid @ModelAttribute(value = "contactToEdit") final EditAdherentContactsForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	List<EditAdherentContact> adhContactEditable = editForm.getAdherentContacts();
	System.out.println("id ..: " + adhContactEditable.get(0).getAdherentId());
	int adhId = adhContactEditable.get(0).getAdherentId();

	if (!pBindingResult.hasErrors()) {
	    List<AdherentContact> contacts = editToContact(adhContactEditable);

	    service.saveAdherentContact(contacts);
	    return "redirect:/adherentDetail?idAdh=" + adhId;
	}

	// voir retour direct à la liste
	return editContact(adhId, pModel, request);
    }

}
