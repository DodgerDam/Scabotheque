package fr.scabois.scabotheque.controller.tablesDeBases;

import org.hibernate.validator.constraints.NotEmpty;

public class EditList {
    @NotEmpty(message = "{modification.notempty}")
    private Integer id;
    @NotEmpty(message = "{modification.notempty}")
    private String libelle;

    EditList(Integer id, String libelle) {
	this.id = id;
	this.libelle = libelle;
    }

    public Integer getId() {
	return id;
    }

    public String getLibelle() {
	return libelle;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setLibelle(String libelle) {
	this.libelle = libelle;
    }

}