package fr.scabois.scabotheque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentContact;
import fr.scabois.scabotheque.bean.adherent.Etat;
import fr.scabois.scabotheque.bean.adherent.FormeJuridique;
import fr.scabois.scabotheque.bean.adherent.Pole;
import fr.scabois.scabotheque.bean.adherent.Role;
import fr.scabois.scabotheque.bean.adherent.Secteur;
import fr.scabois.scabotheque.bean.adherent.Tournee;
import fr.scabois.scabotheque.bean.commun.Activite;
import fr.scabois.scabotheque.bean.commun.Agence;
import fr.scabois.scabotheque.bean.commun.Ape;
import fr.scabois.scabotheque.bean.commun.Commune;
import fr.scabois.scabotheque.bean.commun.TypeContact;
import fr.scabois.scabotheque.controller.adherent.CriteriaAdherent;

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
    public void createAdherent(Adherent dataAdherent) {

	// chargement de l'adherent a modifier
	Adherent newAdh = new Adherent();

	// mise à jour des données
	updateAdherentData(newAdh, dataAdherent);

	// enregistrement de l'adherent
	entityManager.persist(newAdh);
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
    @Transactional
    public void createTypeContact(String libelle) {
	TypeContact newData = new TypeContact();
	newData.setLibelle(libelle);

	entityManager.persist(newData);
    }

    @Override
    @Transactional
    public void editAdherent(Adherent dataAdherent) {

	// chargement de l'adherent a modifier
	Adherent bddAdherent = loadAdherent(dataAdherent.getId());

	// mise à jour des données
	updateAdherentData(bddAdherent, dataAdherent);

	// enregistrement de l'adherent
	entityManager.persist(bddAdherent);
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

    /**
     * Création d'une liste avec tout les type de contacte
     */
    @Override
    public Map<TypeContact, AdherentContact> LoadAdherentContact(int adhId) {
//	List<AdherentContact> contactAdh = new ArrayList<AdherentContact>();

	Map<TypeContact, AdherentContact> map = new HashMap<>();

	List<TypeContact> typeContact = entityManager
		.createQuery("from TypeContact order by libelle", TypeContact.class).getResultList();
	final List<AdherentContact> contactsAdh = entityManager
		.createQuery("from AdherentContact ac where adherent.id = :idAdh ", AdherentContact.class)
		.setParameter("idAdh", adhId).getResultList();

	typeContact.stream().forEach(t -> map.put(t,
		contactsAdh.stream().filter(f -> f.getType().getId() == t.getId()).findFirst().orElse(null)));

	return new TreeMap<>(map);
    }

    @Override
    public List<Adherent> loadAdherents() {
	return entityManager.createQuery("from Adherent", Adherent.class).getResultList();
    }

    @Override
    public List<Adherent> loadAdherents(CriteriaAdherent criteria) {

	List<Adherent> list = entityManager.createQuery("from Adherent adh", Adherent.class).getResultList();

//	// filtre la liste des adherents sur les libellés
	return list.stream().filter(adh -> {
	    boolean isLib = adh.getLibelle().toUpperCase().contains(criteria.getText().toUpperCase());
	    boolean isCode = adh.getCode().toUpperCase().contains(criteria.getText().toUpperCase());
	    boolean isDenom = adh.getDenomination() == null ? false
		    : adh.getDenomination().toUpperCase().contains(criteria.getText().toUpperCase());
	    boolean isPole = criteria.getPoleId() == 0 ? true : adh.getPole().getId().equals(criteria.getPoleId());
	    boolean isSecteur = criteria.getSecteurId() == 0 ? true
		    : adh.getSecteur().getId().equals(criteria.getSecteurId());
	    boolean isActif = criteria.getIsActif() ? true : adh.getEtat().getId() == 1;

	    return (isLib || isDenom || isCode) && isPole && isSecteur && isActif;
	}).collect(Collectors.toList());

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
    public List<TypeContact> loadTypeContact() {
	return entityManager.createQuery("from TypeContact", TypeContact.class).getResultList();
    }

    @Override
    @Transactional
    public void saveAdherentContacts(List<AdherentContact> contacts) {

	// Pour tout les contact de la liste
	contacts.stream().forEach(c -> {
	    AdherentContact adhContact = c.getId() == null ? new AdherentContact()
		    : entityManager.find(AdherentContact.class, c.getId());
	    updateAdherentContactData(adhContact, c);
	    entityManager.persist(adhContact);
	});
    }

    @Override
    @Transactional
    public void saveAgences(List<Agence> agences) {

	// Pour tout les contact de la liste
	agences.stream().forEach(a -> {
	    Agence agence = a.getId() == null ? new Agence() : entityManager.find(Agence.class, a.getId());
	    agence.setLibelle(a.getLibelle());
	    entityManager.persist(agence);
	});
    }

    @Override
    @Transactional
    public void savePoles(List<Pole> poles) {
	// Pour tout les contact de la liste
	poles.stream().forEach(a -> {
	    Pole pole = a.getId() == null ? new Pole() : entityManager.find(Pole.class, a.getId());
	    pole.setLibelle(a.getLibelle());
	    entityManager.persist(pole);
	});
    }

    @Override
    @Transactional
    public void saveRoles(List<Role> roles) {
	// Pour tout les contact de la liste
	roles.stream().forEach(a -> {
	    Role role = a.getId() == null ? new Role() : entityManager.find(Role.class, a.getId());
	    role.setLibelle(a.getLibelle());
	    entityManager.persist(role);
	});
    }

    @Override
    public void saveSecteur(List<Secteur> secteurs) {
	// Pour tout les contact de la liste
	secteurs.stream().forEach(a -> {
	    Secteur secteur = a.getId() == null ? new Secteur() : entityManager.find(Secteur.class, a.getId());
	    secteur.setLibelle(a.getLibelle());
	    entityManager.persist(secteur);
	});
    }

    @Override
    @Transactional
    public void saveTypeContacts(List<TypeContact> typeContacts) {
	// Pour tout les contact de la liste
	typeContacts.stream().forEach(a -> {
	    TypeContact typeContact = a.getId() == null ? new TypeContact()
		    : entityManager.find(TypeContact.class, a.getId());
	    typeContact.setLibelle(a.getLibelle());
	    entityManager.persist(typeContact);
	});
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

    @Override
    @Transactional
    public void supprimeTypeContact(Integer id) {
	TypeContact del = entityManager.find(TypeContact.class, id);
	entityManager.remove(del);
    }

    private AdherentContact updateAdherentContactData(AdherentContact dbbContact, AdherentContact adhContact) {

	dbbContact.setAdherent(adhContact.getAdherent());
	dbbContact.setCivilite(adhContact.getCivilite());
	dbbContact.setFixe(adhContact.getFixe());
	dbbContact.setMail(adhContact.getMail());
	dbbContact.setMobile(adhContact.getMobile());
	dbbContact.setNaissance(adhContact.getNaissance());
	dbbContact.setNom(adhContact.getNom());
	dbbContact.setPhoto(adhContact.getPhoto());
	dbbContact.setPrenom(adhContact.getPrenom());
	dbbContact.setType(adhContact.getType());

	return dbbContact;

    }

    private Adherent updateAdherentData(Adherent bddAdherent, Adherent adherent) {

	bddAdherent.setId(adherent.getId());
	bddAdherent.setCode(adherent.getCode());
	bddAdherent.setCodeERP(adherent.getCodeERP());
	bddAdherent.setLibelle(adherent.getLibelle());
	bddAdherent.setDenomination(adherent.getDenomination());
	bddAdherent.setFormeJuridique(adherent.getFormeJuridique());
	bddAdherent.setDateEntree(adherent.getDateEntree());
	bddAdherent.setAdresse(adherent.getAdresse());
	bddAdherent.setAdresseComplement(adherent.getAdresseComplement());
	bddAdherent.setCommune(adherent.getCommune());
	bddAdherent.setPole(adherent.getPole());
	bddAdherent.setRole(adherent.getRole());
	bddAdherent.setSecteur(adherent.getSecteur());
	bddAdherent.setIsArtipole(adherent.getIsArtipole());
	bddAdherent.setIsCharteArtipole(adherent.getIsCharteArtipole());
	bddAdherent.setIsFlocageArtipole(adherent.getIsFlocageArtipole());
	bddAdherent.setIsWebArtipole(adherent.getIsWebArtipole());
	bddAdherent.setIsFormationCommerce(adherent.getIsFormationCommerce());
	bddAdherent.setIsFacebookArtipole(adherent.getIsFacebookArtipole());
	bddAdherent.setApe(adherent.getApe());
	bddAdherent.setSiren(adherent.getSiren());
	bddAdherent.setSiret(adherent.getSiret());
	bddAdherent.setNumRepMetier(adherent.getNumRepMetier());
	bddAdherent.setRcsRm(adherent.getRcsRm());
	bddAdherent.setRcsCommune(adherent.getRcsCommune());
	bddAdherent.setAgence(adherent.getAgence());
	bddAdherent.setDateClotureExe(adherent.getDateClotureExe());
	bddAdherent.setTournee(adherent.getTournee());
	bddAdherent.setOutilDechargement(adherent.getIsOutilDechargement());
	bddAdherent.setContactComptable(adherent.getContactComptable());
	bddAdherent.setEtat(adherent.getEtat());

	return bddAdherent;
    }

}