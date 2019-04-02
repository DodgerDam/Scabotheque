package fr.scabois.scabotheque.controller.adherent.edit;

import javax.validation.Valid;

public class EditAdherentForm {

    @Valid
    private EditAdherent adherent;

    public void setAdherent(final EditAdherent pAdherent) {
        adherent = pAdherent;
    }

    public EditAdherent getAdherent() {
        return adherent;
    }
}