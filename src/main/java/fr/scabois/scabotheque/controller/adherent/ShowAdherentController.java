package fr.scabois.scabotheque.controller.adherent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.Adherent;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
@RequestMapping(value="/showAdherent")
public class ShowAdherentController {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(@RequestParam(value="idAdh") final int idAdh,final ModelMap pModel) {
        final Adherent adherent = service.LoadAdherent(idAdh);
        
        pModel.addAttribute("pageType", PageType.LIST_ADHERENT);
        pModel.addAttribute("adherent", adherent);
        return "showAdh";
    }
    
}
