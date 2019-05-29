package fr.scabois.scabotheque.controller.adherent.edit;

import java.util.List;

import javax.validation.Valid;

public class EditAdherentContactsForm {

    @Valid
    private List<EditAdherentContact> adherentContacts;

    public List<EditAdherentContact> getAdherentContacts() {
	return adherentContacts;
    }

    public void setAdherentContacts(final List<EditAdherentContact> pContacts) {
	adherentContacts = pContacts;
    }
}