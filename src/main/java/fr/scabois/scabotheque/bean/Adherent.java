package fr.scabois.scabotheque.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adherent")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_adh")
    private String code;

    private String libelle;

    @Column(name = "denom_sociale")
    private String denomination;

    @ManyToOne
    @JoinColumn(name = "form_juridique_id")
    private FormeJuridique formeJuridique;

    @Column(name = "date_entree")
    private Date dateEntree;

    private String adresse;
    @Column(name = "adresse_complement")
    private String adresseComplement;

    @ManyToOne
    private Commune commune;

    @ManyToOne
    private Pole pole;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Secteur secteur;

    @Column(name = "adhesion_artipole")
    private boolean isArtipole;

    @Column(name = "charte_artipole")
    private boolean isCharteArtipole;

    @Column(name = "flocage_artipole")
    private boolean isFlocageArtipole;

    @Column(name = "site_web_artipole")
    private boolean isWebArtipole;

    @Column(name = "formation_commerce")
    private boolean isFormationCommerce;

    @Column(name = "facebook_artipole")
    private boolean isFacebookArtipole;

    @ManyToOne
    private Ape ape;

    private int siren;

    private Integer siret;

    @Column(name = "num_rep_metier")
    private String numRepMetier;

    @Column(name = "rcs_rm")
    private String rcsRm;

    @ManyToOne
    @JoinColumn(name = "rcs_rm_commune_id")
    private Commune rcsCommune;

    @ManyToOne
    private Agence agence;

    @Column(name = "cloture_exercice")
    private Date dateClotureExe;

    @ManyToOne
    private Tournee tournee;

    @Column(name = "outil_dechargement")
    private boolean isOutilDechargement;

    @Column(name = "contact_comptable")
    private String contactComptable;

    @ManyToOne
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

    public void setOutilDechargement(boolean outilDechargement) {
	this.isOutilDechargement = outilDechargement;
    }

    public void setContactComptable(String contactComptable) {
	this.contactComptable = contactComptable;
    }

    public void setEtat(Etat etat) {
	this.etat = etat;
    }

//    @Column(name = "nb_parts")
//    private Integer nbParts;

}