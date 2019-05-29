package fr.scabois.scabotheque.controller.adherent.edit;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import fr.scabois.scabotheque.bean.commun.TypeContact;

public class EditAdherentContact {

    private int adherentId;
    private String civilite;
    @NotEmpty(message = "{modification.fixeNotEmpty}")
    @Pattern(regexp = "^0[1-9](([ ][0-9]{2}){4})$", message = "fixe {modification.phoneFormat}")
    private String fixe;
    private Integer id;
    @NotEmpty(message = "{modification.mailNotEmpty}")
    private String mail;
    @Pattern(regexp = "^0[1-9](([ ][0-9]{2}){4})$", message = "mobile {modification.phoneFormat}")
    private String mobile;
    private Date naissance;
    @NotEmpty(message = "{modification.nomNotEmpty}")
    private String nom;
    private String photo;
    @NotEmpty(message = "{modification.prenomNotEmpty}")
    private String prenom;
    private TypeContact type;
    private int typeContactId;

    public int getAdherentId() {
	return adherentId;
    }

    public String getCivilite() {
	return civilite;
    }

    public String getFixe() {
	return fixe;
    }

    public Integer getId() {
	return id;
    }

    public String getMail() {
	return mail;
    }

    public String getMobile() {
	return mobile;
    }

    public Date getNaissance() {
	return naissance;
    }

    public String getNom() {
	return nom;
    }

    public String getPhoto() {
	return photo;
    }

    public String getPrenom() {
	return prenom;
    }

    public TypeContact getType() {
	return type;
    }

    public int getTypeContactId() {
	return typeContactId;
    }

    public void setAdherentId(int adherentId) {
	this.adherentId = adherentId;
    }

    public void setCivilite(String civilite) {
	this.civilite = civilite;
    }

    public void setFixe(String fixe) {
	this.fixe = fixe;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public void setNaissance(Date naissance) {
	this.naissance = naissance;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public void setPhoto(String photo) {
	this.photo = photo;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public void setType(TypeContact type) {
	this.type = type;
    }

    public void setTypeContactId(int typeContactId) {
	this.typeContactId = typeContactId;
    }
}