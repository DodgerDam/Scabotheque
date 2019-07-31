package fr.scabois.scabotheque.controller.adherent;

import java.util.List;

public class CriteriaAdherent {

    public List<String> adherentIds;
    private String avertissement;
    private String messageMail;
    private String object;
    private int poleId;

    // private Metier metier;
    private int secteurId;
    private String sender;
    private Boolean showAll;
    private String text;
    private int contactFonctionId;

    public List<String> getAdherentIds() {
	return adherentIds;
    }

    public String getAvertissement() {
	return avertissement;
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

    public Boolean getShowAll() {
	return showAll == null ? false : showAll;
    }

    public String getText() {
	return text;
    }

    public int getcontactFonctionId() {
	return contactFonctionId;
    }

    public void setAdherentIds(List<String> adherentIds) {
	this.adherentIds = adherentIds;
    }

    public void setAvertissement(String avertissement) {
	this.avertissement = avertissement;
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

    public void setText(String text) {
	this.text = text;
    }

    public void setcontactFonctionId(int contactFonctionId) {
	this.contactFonctionId = contactFonctionId;
    }

}
