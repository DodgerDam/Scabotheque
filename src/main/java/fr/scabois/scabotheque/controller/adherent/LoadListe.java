package fr.scabois.scabotheque.controller.adherent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import fr.scabois.scabotheque.bean.Commune;
import fr.scabois.scabotheque.services.IServiceAdherent;

@Controller
public class LoadListe {

    @Autowired
    private IServiceAdherent service;

    @RequestMapping("/loadCommuneListe")
    public @ResponseBody String getFilterCommunes(@RequestParam(value = "filter") final String filter) {
	List<Commune> communes = service.LoadCommunes();

	List<Commune> list = communes.stream().filter(c -> {
	    boolean isLib = c.getLibelle().toUpperCase().contains(filter.toUpperCase());
	    boolean isCode = c.getCodePostal().toUpperCase().contains(filter.toUpperCase());
	    return isLib || isCode;
	}).collect(Collectors.toList());

	if (list.size() < 150) {
	    String jsonList = new Gson().toJson(list);
	    return jsonList;
	} else {
	    return "[{\"id\":0,\"libelle\":\"Trop de resultat\",\"codePostal\":\"\"}]";
	}
    }

}