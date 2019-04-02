package fr.scabois.scabotheque.controller.tablesDeBases;

import java.util.List;

import javax.validation.Valid;

public class EditListForm {

    @Valid
    private List<EditList> list;

    public void setList(final List<EditList> list) {
	this.list = list;
    }

    public List<EditList> getList() {
	return list;
    }
}