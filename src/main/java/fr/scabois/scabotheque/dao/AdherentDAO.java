package fr.scabois.scabotheque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.scabois.scabotheque.bean.Activite;
import fr.scabois.scabotheque.bean.Adherent;
import fr.scabois.scabotheque.bean.Agence;
import fr.scabois.scabotheque.bean.Ape;
import fr.scabois.scabotheque.bean.Commune;
import fr.scabois.scabotheque.bean.Etat;
import fr.scabois.scabotheque.bean.FormeJuridique;
import fr.scabois.scabotheque.bean.Pole;
import fr.scabois.scabotheque.bean.Role;
import fr.scabois.scabotheque.bean.Secteur;
import fr.scabois.scabotheque.bean.Tournee;

@Repository
public class AdherentDAO implements IAdherentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createActivite(String libelle) {
	Activite newData = new Activite();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    @Transactional
    public void createAgence(String libelle) {
	Agence newData = new Agence();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    @Transactional
    public void createPole(String libelle) {
	Pole newData = new Pole();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    @Transactional
    public void createRole(String libelle) {
	Role newData = new Role();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    @Transactional
    public void createSecteur(String libelle) {
	Secteur newData = new Secteur();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    public List<Activite> loadActivites() {
	return entityManager.createQuery("from Activite", Activite.class).getResultList();
    }

    @Override
    public List<Activite> loadActivitesAdherents() {
//	return entityManager.createQuery("select adh.activite from Adherent adh", Activite.class).getResultList();
	return null;
    }

    @Override
    public Adherent loadAdherent(int idAdh) {
	try {
	    return entityManager.find(Adherent.class, idAdh);
	} catch (NoResultException e) {
	    return null;
	}
    }

    @Override
    public List<Adherent> loadAdherents() {
	return entityManager.createQuery("from Adherent", Adherent.class).getResultList();
    }

    @Override
    public List<Agence> loadAgences() {
	return entityManager.createQuery("from Agence", Agence.class).getResultList();
    }

    @Override
    public List<Ape> loadApes() {
	return entityManager.createQuery("from Ape", Ape.class).getResultList();
    }

    @Override
    public List<Commune> loadCommunes() {
	return entityManager.createQuery("from Commune", Commune.class).getResultList();
    }

    @Override
    public List<Etat> loadEtats() {
	return entityManager.createQuery("from Etat", Etat.class).getResultList();
    }

    @Override
    public List<FormeJuridique> loadFormesJuridiques() {
	return entityManager.createQuery("from FormeJuridique", FormeJuridique.class).getResultList();
    }

    @Override
    public List<Pole> loadPoles() {
	return entityManager.createQuery("from Pole", Pole.class).getResultList();
    }

    @Override
    public List<Role> loadRoles() {
	return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public List<Secteur> loadSecteurs() {
	return entityManager.createQuery("from Secteur", Secteur.class).getResultList();
    }

    @Override
    public List<Tournee> loadTournees() {
	return entityManager.createQuery("from Tournee", Tournee.class).getResultList();
    }

    @Override
    @Transactional
    public void saveAdherent(Adherent pAdherent) {

	// chargement de l'adherent a modifier
	Adherent adhToSave = loadAdherent(pAdherent.getId());

	// mise à jour des données
	adhToSave.setId(pAdherent.getId());
	adhToSave.setCode(pAdherent.getCode());
	adhToSave.setLibelle(pAdherent.getLibelle());
	adhToSave.setDenomination(pAdherent.getDenomination());
	adhToSave.setFormeJuridique(pAdherent.getFormeJuridique());
	adhToSave.setDateEntree(pAdherent.getDateEntree());
	adhToSave.setAdresse(pAdherent.getAdresse());
	adhToSave.setAdresseComplement(pAdherent.getAdresseComplement());
	adhToSave.setCommune(pAdherent.getCommune());
	adhToSave.setPole(pAdherent.getPole());
	adhToSave.setRole(pAdherent.getRole());
	adhToSave.setSecteur(pAdherent.getSecteur());
	adhToSave.setIsArtipole(pAdherent.getIsArtipole());
	adhToSave.setIsCharteArtipole(pAdherent.getIsCharteArtipole());
	adhToSave.setIsFlocageArtipole(pAdherent.getIsFlocageArtipole());
	adhToSave.setIsWebArtipole(pAdherent.getIsWebArtipole());
	adhToSave.setIsFormationCommerce(pAdherent.getIsFormationCommerce());
	adhToSave.setIsFacebookArtipole(pAdherent.getIsFacebookArtipole());
	adhToSave.setApe(pAdherent.getApe());
	adhToSave.setSiren(pAdherent.getSiren());
	adhToSave.setSiret(pAdherent.getSiret());
	adhToSave.setNumRepMetier(pAdherent.getNumRepMetier());
	adhToSave.setRcsRm(pAdherent.getRcsRm());
	adhToSave.setRcsCommune(pAdherent.getRcsCommune());
	adhToSave.setAgence(pAdherent.getAgence());
	adhToSave.setDateClotureExe(pAdherent.getDateClotureExe());
	adhToSave.setTournee(pAdherent.getTournee());
	adhToSave.setOutilDechargement(pAdherent.getIsOutilDechargement());
	adhToSave.setContactComptable(pAdherent.getContactComptable());
	adhToSave.setEtat(pAdherent.getEtat());

	// enregistrement de l'adherent
	entityManager.persist(adhToSave);
    }

    @Override
    @Transactional
    public void supprimeActivite(Integer id) {
	Activite del = entityManager.find(Activite.class, id);
	entityManager.remove(del);
    }

    @Override
    @Transactional
    public void supprimeAgence(Integer id) {
	Agence del = entityManager.find(Agence.class, id);
	entityManager.remove(del);
    }

    @Override
    @Transactional
    public void supprimePole(Integer id) {
	Pole del = entityManager.find(Pole.class, id);
	entityManager.remove(del);
    }

    @Override
    @Transactional
    public void supprimeRole(Integer id) {
	Role del = entityManager.find(Role.class, id);
	entityManager.remove(del);
    }

    @Override
    @Transactional
    public void supprimeSecteur(Integer id) {
	Secteur del = entityManager.find(Secteur.class, id);
	entityManager.remove(del);
    }

}