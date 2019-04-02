package fr.scabois.scabotheque.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="code_ape")
public class Ape {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String libelle;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
        return libelle;
    }

    public void setLibelle(final String pLibelle) {
        libelle = pLibelle;
    }

}