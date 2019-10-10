package fr.scabois.scabotheque.controller.adherent;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAdherent {

    public List<String> adherentIds;
    private String avertissement;
    private List<Integer> contactFonctionIds = new ArrayList<>();

    private boolean mailingAdministratif = true;
    private boolean mailingCommerce = true;
    private boolean mailingCompta = true;
    private boolean mailingDirigeant = true;
    private String messageMail;
    private String object;

    private int poleId;
    // private Metier metier;
    private int secteurId;
    private String sender;
    private boolean showAll = false;
    private boolean showSousCompte = true;
    private String text;

    public List<String> getAdherentIds() {
	return adherentIds;
    }

    public String getAvertissement() {
	return avertissement;
    }

    public List<Integer> getContactFonctionIds() {
	return contactFonctionIds;
    }

    public String getMessageMail() {
	return messageMail;
    }

    public String getObject() {
	return object;
    }

    public int getPoleId() {
	return poleId;
    }

    public int getSecteurId() {
	return secteurId;
    }

    public String getSender() {
	return sender;
    }

    public boolean getShowAll() {
	return showAll;
    }

    public boolean getShowSousCompte() {
	return showSousCompte;
    }

    public String getText() {
	return text;
    }

    public boolean isMailingAdministratif() {
	return mailingAdministratif;
    }

    public boolean isMailingCommerce() {
	return mailingCommerce;
    }

    public boolean isMailingCompta() {
	return mailingCompta;
    }

    public boolean isMailingDirigeant() {
	return mailingDirigeant;
    }

    public void setAdherentIds(List<String> adherentIds) {
	this.adherentIds = adherentIds;
    }

    public void setAvertissement(String avertissement) {
	this.avertissement = avertissement;
    }

    public void setContactFonctionIds(List<Integer> contactFonctionIds) {
	this.contactFonctionIds = contactFonctionIds;
    }

    public void setMailingAdministratif(boolean mailingAdministratif) {
	this.mailingAdministratif = mailingAdministratif;
    }

    public void setMailingCommerce(boolean mailingCommerce) {
	this.mailingCommerce = mailingCommerce;
    }

    public void setMailingCompta(boolean mailingCompta) {
	this.mailingCompta = mailingCompta;
    }

    public void setMailingDirigeant(boolean mailingDirigeant) {
	this.mailingDirigeant = mailingDirigeant;
    }

    public void setMessageMail(String message) {
	this.messageMail = message;
    }

    public void setObject(String object) {
	this.object = object;
    }

    public void setPoleId(int poleId) {
	this.poleId = poleId;
    }

    public void setSecteurId(int secteurId) {
	this.secteurId = secteurId;
    }

    public void setSender(String sender) {
	this.sender = sender;
    }

    public void setShowAll(Boolean showAll) {
	this.showAll = showAll;
    }

    public void setShowSousCompte(boolean showSousCompte) {
	this.showSousCompte = showSousCompte;
    }

    public void setText(String text) {
	this.text = text;
    }

}
