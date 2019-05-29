package fr.scabois.scabotheque.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, final ModelMap pModel,
	    HttpServletRequest request, HttpServletResponse response) {

	if (error != null) {
	    pModel.addAttribute("error", "Nom d'utilisateur ou mote de passe incorrect !");
	}

	if (logout != null) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    new SecurityContextLogoutHandler().logout(request, response, auth);
	    pModel.addAttribute("msg", "Vous êtes déconnecté !");
	}
	pModel.addAttribute("setViewName", "login");

	return "login";
    }

}