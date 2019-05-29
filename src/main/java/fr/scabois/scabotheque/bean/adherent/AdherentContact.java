package fr.scabois.scabotheque.bean.adherent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.scabois.scabotheque.bean.HasId;
import fr.scabois.scabotheque.bean.commun.TypeContact;

@Entity
@Table(name = "adherent_contact")
public class AdherentContact implements HasId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;
//    @JoinColumn(name = "adherent_id")
//    private int adherentId;
    private String civilite;
    private String fixe;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mail;
    private String mobile;
    private Date naissance;
    private String nom;
    private String photo;
    private String prenom;
    @ManyToOne
    @JoinColumn(name = "type_contact_id")
    private TypeContact type;

    public Adherent getAdherent() {
	return adherent;
    }

    public String getCivilite() {
	return civilite;
    }

    public String getFixe() {
	return fixe;
    }

    @Override
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

    public void setAdherent(Adherent adherent) {
	this.adherent = adherent;
    }

    public void setCivilite(String civilite) {
	this.civilite = civilite;
    }

    public void setFixe(String fixe) {
	this.fixe = fixe;
    }

    @Override
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

}