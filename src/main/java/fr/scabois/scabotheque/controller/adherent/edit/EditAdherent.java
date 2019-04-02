package fr.scabois.scabotheque.controller.adherent.edit;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import fr.scabois.scabotheque.bean.Agence;
import fr.scabois.scabotheque.bean.Ape;
import fr.scabois.scabotheque.bean.Commune;
import fr.scabois.scabotheque.bean.Etat;
import fr.scabois.scabotheque.bean.FormeJuridique;
import fr.scabois.scabotheque.bean.Pole;
import fr.scabois.scabotheque.bean.Role;
import fr.scabois.scabotheque.bean.Secteur;
import fr.scabois.scabotheque.bean.Tournee;

public class EditAdherent {
    // @NotEmpty(message="{modification.course.quantite.notempty}")
    // @Pattern(regexp="\\d*", message="{modification.course.quantite.numerique}")
    // message="{modification.course.quantite.numerique}")
    // @NotEmpty(message = "{modification.notempty}")
    // @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}", message =
    // "{modification.course.quantite.numerique}")
    // private String mail;
    // @NotNull(message = "{modification.notempty}")
    // @Min(value = 0L, message = "modification.number.positive")

    private Integer id;
    @NotEmpty(message = "{modification.notempty}")
    private String code;
    @NotEmpty(message = "{modification.notempty}")
    private String libelle;
    @NotEmpty(message = "{modification.notempty}")
    private String denomination;
    private FormeJuridique formeJuridique;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "{modification.notempty}")
    private Date dateEntree;
    @NotEmpty(message = "{modification.notempty}")
    private String adresse;
    private String adresseComplement;
//    @NotEmpty(message = "{modification.notempty}")
    private Commune commune;
    private Pole pole;
    private Role role;
    private Secteur secteur;
    private boolean isArtipole;
    private boolean isCharteArtipole;
    private boolean isFlocageArtipole;
    private boolean isWebArtipole;
    private boolean isFormationCommerce;
    private boolean isFacebookArtipole;
    private Ape ape;
    private int siren;
    private Integer siret;
    private String numRepMetier;
    @NotEmpty(message = "{modification.notempty}")
    private String rcsRm;
    private Commune rcsCommune;
    private Agence agence;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateClotureExe;
    private Tournee tournee;
    private boolean isOutilDechargement;
    private String contactComptable;
    private Etat etat;

    public Integer getId() {
	return id;
    }

    public String getCode() {
	return code;
    }

    public String getLibelle() {
	return libelle;
    }

    public String getDenomination() {
	return denomination;
    }

    public FormeJuridique getFormeJuridique() {
	return formeJuridique;
    }

    public Date getDateEntree() {
	return dateEntree;
    }

    public String getAdresse() {
	return adresse;
    }

    public String getAdresseComplement() {
	return adresseComplement;
    }

    public Commune getCommune() {
	return commune;
    }

    public Pole getPole() {
	return pole;
    }

    public Role getRole() {
	return role;
    }

    public Secteur getSecteur() {
	return secteur;
    }

    public boolean getIsArtipole() {
	return isArtipole;
    }

    public boolean getIsCharteArtipole() {
	return isCharteArtipole;
    }

    public boolean getIsFlocageArtipole() {
	return isFlocageArtipole;
    }

    public boolean getIsWebArtipole() {
	return isWebArtipole;
    }

    public boolean getIsFormationCommerce() {
	return isFormationCommerce;
    }

    public boolean getIsFacebookArtipole() {
	return isFacebookArtipole;
    }

    public Ape getApe() {
	return ape;
    }

    public int getSiren() {
	return siren;
    }

    public Integer getSiret() {
	return siret;
    }

    public String getNumRepMetier() {
	return numRepMetier;
    }

    public String getRcsRm() {
	return rcsRm;
    }

    public Commune getRcsCommune() {
	return rcsCommune;
    }

    public Agence getAgence() {
	return agence;
    }

    public Date getDateClotureExe() {
	return dateClotureExe;
    }

    public Tournee getTournee() {
	return tournee;
    }

    public boolean getIsOutilDechargement() {
	return isOutilDechargement;
    }

    public String getContactComptable() {
	return contactComptable;
    }

    public Etat getEtat() {
	return etat;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public void setLibelle(String libelle) {
	this.libelle = libelle;
    }

    public void setDenomination(String denomination) {
	this.denomination = denomination;
    }

    public void setFormeJuridique(FormeJuridique formeJuridique) {
	this.formeJuridique = formeJuridique;
    }

    public void setDateEntree(Date dateEntree) {
	this.dateEntree = dateEntree;
    }

    public void setAdresse(String adresse) {
	this.adresse = adresse;
    }

    public void setAdresseComplement(String adresseComplement) {
	this.adresseComplement = adresseComplement;
    }

    public void setCommune(Commune commune) {
	this.commune = commune;
    }

    public void setPole(Pole pole) {
	this.pole = pole;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public void setSecteur(Secteur secteur) {
	this.secteur = secteur;
    }

    public void setIsArtipole(boolean isArtipole) {
	this.isArtipole = isArtipole;
    }

    public void setIsCharteArtipole(boolean isCharteArtipole) {
	this.isCharteArtipole = isCharteArtipole;
    }

    public void setIsFlocageArtipole(boolean isFlocageArtipole) {
	this.isFlocageArtipole = isFlocageArtipole;
    }

    public void setIsWebArtipole(boolean isWebArtipole) {
	this.isWebArtipole = isWebArtipole;
    }

    public void setIsFormationCommerce(boolean isFormationCommerce) {
	this.isFormationCommerce = isFormationCommerce;
    }

    public void setIsFacebookArtipole(boolean isFacebookArtipole) {
	this.isFacebookArtipole = isFacebookArtipole;
    }

    public void setApe(Ape ape) {
	this.ape = ape;
    }

    public void setSiren(int siren) {
	this.siren = siren;
    }

    public void setSiret(Integer siret) {
	this.siret = siret;
    }

    public void setNumRepMetier(String numRepMetier) {
	this.numRepMetier = numRepMetier;
    }

    public void setRcsRm(String rcsRm) {
	this.rcsRm = rcsRm;
    }

    public void setRcsCommune(Commune rcsCommune) {
	this.rcsCommune = rcsCommune;
    }

    public void setAgence(Agence agence) {
	this.agence = agence;
    }

    public void setDateClotureExe(Date dateClotureExe) {
	this.dateClotureExe = dateClotureExe;
    }

    public void setTournee(Tournee tournee) {
	this.tournee = tournee;
    }

    public void setIsOutilDechargement(boolean outilDechargement) {
	this.isOutilDechargement = outilDechargement;
    }

    public void setContactComptable(String contactComptable) {
	this.contactComptable = contactComptable;
    }

    public void setEtat(Etat etat) {
	this.etat = etat;
    }

}