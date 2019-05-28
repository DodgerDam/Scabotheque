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
import fr.scabois.scabotheque.bean.adherent.Pole;
import fr.scabois.scabotheque.bean.adherent.Role;
import fr.scabois.scabotheque.bean.adherent.Secteur;
import fr.scabois.scabotheque.bean.commun.Activite;
import fr.scabois.scabotheque.bean.commun.Agence;
import fr.scabois.scabotheque.bean.commun.TypeContact;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;
import fr.scabois.scabotheque.utils.IdLibelle;

@Controller
public class TablesBasesController {

    private static final String ACTIVITE_CONST = "Activite";
    private static final String AGENCE_CONST = "Agence";
    private static final String POLE_CONST = "Pole";
    private static final String ROLE_CONST = "Role";
    private static final String SECTEUR_CONST = "Secteur";
    private static final String TYPE_CONTACT_CONST = "TypeContact";

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = { "/parametrage**" }, method = RequestMethod.GET)
    public String afficher(@RequestParam(value = "type") final String typeList, final ModelMap pModel) {

	if (pModel.get("editList") == null) {

	    // Tout affichage de table Id-Libelle passe par cette servlet
	    List<HasIdLibelle> listIdLibelle = new ArrayList<HasIdLibelle>();

	    switch (typeList) {
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
	    case TYPE_CONTACT_CONST:
		listIdLibelle.addAll(service.LoadTypeContact());
		break;
	    }

	    List<EditIdLibList> listToEdit = new ArrayList<>();
	    listIdLibelle.stream().forEach(i -> listToEdit.add(new EditIdLibList(i.getId(), i.getLibelle())));

	    EditIdLibListForm listForm = new EditIdLibListForm();
	    listForm.setList(listToEdit);

	    pModel.addAttribute("editList", listForm);
	    if (pModel.get("creation") == null) {
		pModel.addAttribute("creation", new CreationForm());
	    }
	}

	pModel.addAttribute("pageType", PageType.TABLES_BASE);
	pModel.addAttribute("pageLink", typeList);

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

    @RequestMapping(value = { "/ajoutTypeContact" }, method = RequestMethod.POST)
    public String ajoutTypeContact(@Valid @ModelAttribute(value = "creation") final CreationForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
	    service.createTypeContact(creation.getLibelle());
	}

	return afficher(TYPE_CONTACT_CONST, pModel);
    }

    @RequestMapping(value = { "/editActivite" }, method = RequestMethod.POST)
    public String modifierActivite(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<Activite> computeList = new IdLibelle<>(Activite.class);
//	    service.saveActivite(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=Activite";
	}

	return afficher(ACTIVITE_CONST, pModel);
    }

    @RequestMapping(value = { "/editAgence" }, method = RequestMethod.POST)
    public String modifierAgence(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<Agence> computeList = new IdLibelle<>(Agence.class);
	    service.saveAgence(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=Agence";
	}

	return afficher(AGENCE_CONST, pModel);
    }

    @RequestMapping(value = { "/editPole" }, method = RequestMethod.POST)
    public String modifierPole(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<Pole> computeList = new IdLibelle<>(Pole.class);
	    service.savePole(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=Pole";
	}

	return afficher(POLE_CONST, pModel);
    }

    @RequestMapping(value = { "/editRole" }, method = RequestMethod.POST)
    public String modifierRole(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<Role> computeList = new IdLibelle<>(Role.class);
	    service.saveRole(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=Role";
	}

	return afficher(ROLE_CONST, pModel);
    }

    @RequestMapping(value = { "/editSecteur" }, method = RequestMethod.POST)
    public String modifierSecteur(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<Secteur> computeList = new IdLibelle<>(Secteur.class);
	    service.saveSecteur(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=Secteur";
	}

	return afficher(SECTEUR_CONST, pModel);
    }

    @RequestMapping(value = { "/editTypeContact" }, method = RequestMethod.POST)
    public String modifierTypeContact(@Valid @ModelAttribute(value = "editList") final EditIdLibListForm editForm,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    IdLibelle<TypeContact> computeList = new IdLibelle<>(TypeContact.class);
	    service.saveTypeContact(computeList.setEditList(editForm.getList()));
	    return "redirect:/parametrage?type=TypeContact";
	}

	return afficher(TYPE_CONTACT_CONST, pModel);
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

    @RequestMapping(value = "/supprimeTypeContact", method = RequestMethod.GET)
    public String supprimeTypeContact(@RequestParam(value = "id") final Integer id, final ModelMap pModel) {
	try {
	    service.supprimerTypeContact(id);
	    return afficher(TYPE_CONTACT_CONST, pModel);
	} catch (Exception e) {
	    pModel.addAttribute("erreur", "Impossible de terminer la demande <br>" + e.getMessage());
	    return afficher(TYPE_CONTACT_CONST, pModel);
	}
    }

}
