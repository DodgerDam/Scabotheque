package fr.scabois.scabotheque.bean.commun;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commune")
public class Commune {

    @Column(name = "code_postal")
    private String codePostal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    public String getCodePostal() {
	return codePostal;
    }

    public Integer getId() {
	return id;
    }

    public String getLibelle() {
	return libelle;
    }

    public void setCodePostal(final String pCodePostal) {
	codePostal = pCodePostal;
    }

    public void setId(final Integer pId) {
	id = pId;
    }

    public void setLibelle(final String pLibelle) {
	libelle = pLibelle;
    }

}