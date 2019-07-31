package fr.scabois.scabotheque.controller.adherent.edit;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import fr.scabois.scabotheque.bean.commun.ContactFonction;

public class EditAdherentContact {

    private int adherentId;
    private String civilite;

    private int contactFonctionId;
    private MultipartFile file;
    // @NotEmpty(message = "{modification.fixeNotEmpty}")
    @Pattern(regexp = "^0[1-9](([ ][0-9]{2}){4})$", message = "{modification.phoneFixeFormat}")
    private String fixe;
    private ContactFonction fonction;
    private Integer id;
    private boolean isAdministratif;
    private boolean isCommercial;
    private boolean isComptabilite;
    private boolean isDirigeant;
    @NotEmpty(message = "{modification.mailNotEmpty}")
    private String mail;

    @Pattern(regexp = "^$|0[6-9](([ ][0-9]{2}){4})$", message = "{modification.phoneMobileFormat}")
    private String mobile;
    private Date naissance;
    @NotEmpty(message = "{modification.nomNotEmpty}")
    private String nom;
    private String photoImg;
    @NotEmpty(message = "{modification.prenomNotEmpty}")
    private String prenom;

    public int getAdherentId() {
	return adherentId;
    }

    public String getCivilite() {
	return civilite;
    }

    public int getContactFonctionId() {
	return contactFonctionId;
    }

    public MultipartFile getFile() {
	return file;
    }

    public String getFixe() {
	return fixe;
    }

    public ContactFonction getFonction() {
	return fonction;
    }

    public Integer getId() {
	return id;
    }

    public boolean getIsAdministratif() {
	return isAdministratif;
    }

    public boolean getIsCommercial() {
	return isCommercial;
    }

    public boolean getIsComptabilite() {
	return isComptabilite;
    }

    public boolean getIsDirigeant() {
	return isDirigeant;
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

    public String getPhotoImg() {
	return photoImg;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setAdherentId(int adherentId) {
	this.adherentId = adherentId;
    }

    public void setCivilite(String civilite) {
	this.civilite = civilite;
    }

    public void setContactFonctionId(int contactFonctionId) {
	this.contactFonctionId = contactFonctionId;
    }

    public void setFile(MultipartFile file) {
	this.file = file;
    }

    public void setFixe(String fixe) {
	this.fixe = fixe;
    }

    public void setFonction(ContactFonction fonction) {
	this.fonction = fonction;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setIsAdministratif(boolean isAdministratif) {
	this.isAdministratif = isAdministratif;
    }

    public void setIsCommercial(boolean isCommercial) {
	this.isCommercial = isCommercial;
    }

    public void setIsComptabilite(boolean isComptabilite) {
	this.isComptabilite = isComptabilite;
    }

    public void setIsDirigeant(boolean isDirigeant) {
	this.isDirigeant = isDirigeant;
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

    public void setPhotoImg(String photoImg) {
	this.photoImg = photoImg;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }
}