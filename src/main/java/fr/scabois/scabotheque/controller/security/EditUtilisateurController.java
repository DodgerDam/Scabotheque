package fr.scabois.scabotheque.controller.security;

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

import fr.scabois.scabotheque.bean.security.User;
import fr.scabois.scabotheque.bean.security.UserRole;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.enums.RoleEnum;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class EditUtilisateurController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(value = "/parametrage/listeUtilisateurs", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {

	List<User> utilisateurList = service.LoadUtilisateurs();

	List<EditUtilisateur> editUsersList = utilisateurToEdit(utilisateurList);

	if (pModel.get("utilisateurListe") == null) {
	    EditUtilisateursForm utilisateurForm = new EditUtilisateursForm(editUsersList);
	    pModel.addAttribute("utilisateurListe", utilisateurForm);
	} else {
	    pModel.addAttribute("utilisateurListe", pModel.get("utilisateurListe"));
	}

	pModel.addAttribute("pageType", PageType.GESTION_USERS);

	if (pModel.get("creation") == null) {
	    pModel.addAttribute("creation", new CreationUtilisateurForm());
	}

	return "listeUtilisateurs";
    }

    @RequestMapping(value = { "/parametrage/AjoutUtilisateur" }, method = RequestMethod.POST)
    public String ajoutUtilisateur(@Valid @ModelAttribute(value = "creation") final CreationUtilisateurForm creation,
	    final BindingResult pBindingResult, final ModelMap pModel) {

	if (!pBindingResult.hasErrors()) {
	    service.createUtilisateur(creation.getUserName(), "{noop}" + creation.getPassword());
	}

	return afficher(pModel);
    }

    private List<User> editToUtilisateur(EditUtilisateursForm utlList) {
	List<User> list = new ArrayList<>();

	utlList.getList().stream().forEach(u -> {
	    User usr = new User();

	    usr.setId(u.getId());
	    usr.setEnabled(u.getEnabled());
	    usr.setPassword(u.getNewPassword().isEmpty() ? u.getPassword() : u.getNewPassword());
	    usr.setUsername(u.getUsername());

	    u.getUserRoles().stream().forEach(ur -> {
		if (ur.isActif()) {
		    UserRole usrRole = new UserRole();

		    usrRole.setId(ur.getId());
		    usrRole.setRole(ur.getRole());
		    usrRole.setUser(service.LoadUtilisateur(u.getId()));

		    usr.getRoles().add(usrRole);
		}
	    });

	    list.add(usr);
	});

	return list;
    }

    @RequestMapping(value = { "/parametrage/listeUtilisateurs" }, method = RequestMethod.POST)
    public String editUtl(@Valid @ModelAttribute(value = "utilisateurListe") final EditUtilisateursForm utlList,
	    final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

	if (!pBindingResult.hasErrors()) {
	    List<User> users = editToUtilisateur(utlList);

	    service.saveUtilisateur(users);
	    users.stream().forEach(u -> {
		service.saveUtilisateurRoles(u.getId(), u.getRoles());
	    });
	    return "redirect:/parametrage/listeUtilisateurs";
	}

	return afficher(pModel);
    }

    private List<EditUtilisateur> utilisateurToEdit(List<User> utilisateurList) {

	List<EditUtilisateur> retour = new ArrayList<>();

	utilisateurList.stream().forEach(c -> {
	    EditUtilisateur edit = new EditUtilisateur();
	    edit.setId(c.getId());
	    edit.setEnabled(c.getEnabled());
	    edit.setUsername(c.getUsername());
	    edit.setPassword(c.getPassword());

	    List<EditUtilisateurRole> utlRoles = new ArrayList<>();
	    for (RoleEnum role : RoleEnum.values()) {
		Optional<UserRole> usrRole = c.getRoles().stream().filter(r -> r.getRole().equals(role)).findFirst();

		if (usrRole.isPresent()) {
		    utlRoles.add(new EditUtilisateurRole(usrRole.get().getId(), role.libelle, role, true));
		} else {
		    utlRoles.add(new EditUtilisateurRole(0, role.libelle, role, false));
		}
	    }
	    edit.setUserRoles(utlRoles);

	    retour.add(edit);
	});

	return retour;
    }

}
