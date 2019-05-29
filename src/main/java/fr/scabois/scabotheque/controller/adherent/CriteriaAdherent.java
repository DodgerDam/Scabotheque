package fr.scabois.scabotheque.controller.adherent;

public class CriteriaAdherent {

    private Boolean isActif;
    private int poleId;
//    private Metier metier;
    private int secteurId;
    private String text;

    public Boolean getIsActif() {
	return isActif;
    }

    public int getPoleId() {
	return poleId;
    }

    public int getSecteurId() {
	return secteurId;
    }

    public String getText() {
	return text;
    }

    public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
    }

    public void setPoleId(int poleId) {
	this.poleId = poleId;
    }

    public void setSecteurId(int secteurId) {
	this.secteurId = secteurId;
    }

    public void setText(String text) {
	this.text = text;
    }

}
