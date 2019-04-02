package fr.scabois.scabotheque.controller.tablesDeBases;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.HasIdLibelle;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class TablesBasesController {

    private static final String ACTIVITE_CONST = "Activite";
    private static final String AGENCE_CONST = "Agence";
    private static final String POLE_CONST = "Pole";
    private static final String ROLE_CONST = "Role";
    private static final String SECTEUR_CONST = "Secteur";

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/parametrage" }, method = RequestMethod.GET)
    public String afficher(@RequestParam(value = "type") final String typeParam, final ModelMap pModel) {

	if (pModel.get("editList") == null) {

	    // Tout affichage de table Id-Libelle passe par cette servlet
	    List<HasIdLibelle> listIdLibelle = new ArrayList<HasIdLibelle>();

	    switch (typeParam) {
	    case AGENCE_CONST:
		listIdLibelle.addAll(service.LoadAgences());
		break;
	    case ACTIVITE_CONST:
		listIdLibelle.addAll(service.LoadActivites());
		break;
	    case POLE_CONST:
		listIdLibelle.addAll(service.LoadPoles());
		break;
	    case ROLE_CONST:
		listIdLibelle.addAll(service.LoadRoles());
		break;
	    case SECTEUR_CONST:
		listIdLibelle.addAll(service.LoadSecteurs());
		break;
	    }

	    List<EditList> listToEdit = new ArrayList<>();
	    listIdLibelle.stream().forEach(i -> listToEdit.add(new EditList(i.getId(), i.getLibelle())));

	    EditListForm listForm = new EditListForm();
	    listForm.setList(listToEdit);

	    pModel.addAttribute("editList", listForm);
	    if (pModel.get("creation") == null) {
		pModel.addAttribute("creation", new CreationForm());
	    }
	}

	pModel.addAttribute("pageType", PageType.TABLES_BASE);
	pModel.addAttribute("pageLink", typeParam);

	// Implique que le nom des Tiles soit correctement alimenté
	return "listIdLibelle";
    }

    @RequestMapping(value = { "/ajoutActivite" }, method = RequestMethod.POST)
    public String ajoutActivite(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createActivite(creation.getLibelle());
	}

	return afficher(ACTIVITE_CONST, pModel);
    }

    @RequestMapping(value = { "/ajoutAgence" }, method = RequestMethod.POST)
    public String ajoutAgence(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createAgence(creation.getLibelle());
	}

	return afficher(AGENCE_CONST, pModel);
    }

    @RequestMapping(value = { "/ajoutPole" }, method = RequestMethod.POST)
    public String ajoutPole(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createPole(creation.getLibelle());
	}

	return afficher(POLE_CONST, pModel);
    }

    @RequestMapping(value = { "/ajoutRole" }, method = RequestMethod.POST)
    public String ajoutRole(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createRole(creation.getLibelle());
	}

	return afficher(ROLE_CONST, pModel);
    }

    @RequestMapping(value = { "/ajoutSecteur" }, method = RequestMethod.POST)
    public String ajoutSecteur(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createSecteur(creation.getLibelle());
	}

	return afficher(SECTEUR_CONST, pModel);
    }

    @RequestMapping(value = { "/editAgence" }, method = RequestMethod.POST)
    public String modifier(@Valid @ModelAttribute(value = "editList") final EditListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

//	EditIdLibelle adhEditable = editForm.getIdLibelle();
//	Adherent adh = editToAdh(adhEditable);
//
//	if (!pBindingResult.hasErrors()) {
//	    service.saveAdherent(adh);
//	    return "redirect:/showAdherent?idAdh=" + adh.getId();
//	}

	return afficher(AGENCE_CONST, pModel);
    }

    @RequestMapping(value = "/supprimeActivite", method = RequestMethod.GET)
    public String supprimeActivite(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	service.supprimerActivite(id);
	return afficher(ACTIVITE_CONST, pModel);
    }

    @RequestMapping(value = "/supprimeAgence", method = RequestMethod.GET)
    public String supprimeAgence(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	service.supprimerAgence(id);
	return afficher(AGENCE_CONST, pModel);
    }

    @RequestMapping(value = "/supprimePole", method = RequestMethod.GET)
    public String supprimePole(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	service.supprimerPole(id);
	return afficher(POLE_CONST, pModel);
    }

    @RequestMapping(value = "/supprimeRole", method = RequestMethod.GET)
    public String supprimeRole(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	service.supprimerRole(id);
	return afficher(ROLE_CONST, pModel);
    }

    @RequestMapping(value = "/supprimeSecteur", method = RequestMethod.GET)
    public String supprimeSecteur(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	service.supprimerSecteur(id);
	return afficher(SECTEUR_CONST, pModel);
    }
}
