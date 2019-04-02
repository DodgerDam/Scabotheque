package fr.scabois.scabotheque.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements HasIdLibelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @Override
    public Integer getId() {
	return id;
    }

    @Override
    public String getLibelle() {
	return libelle;
    }

    @Override
    public void setId(final Integer pId) {
	id = pId;
    }

    @Override
    public void setLibelle(final String pLibelle) {
	libelle = pLibelle;
    }

}