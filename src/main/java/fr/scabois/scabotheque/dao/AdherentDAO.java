package fr.scabois.scabotheque.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.scabois.scabotheque.bean.adherent.Adherent;
import fr.scabois.scabotheque.bean.adherent.AdherentCommentaire;
import fr.scabois.scabotheque.bean.adherent.AdherentContactRole;
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
import fr.scabois.scabotheque.bean.commun.ContactFonction;
import fr.scabois.scabotheque.controller.adherent.CriteriaAdherent;
import fr.scabois.scabotheque.enums.PageType;

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
    public int createAdherent(Adherent dataAdherent) {

	// chargement de l'adherent a modifier
	Adherent newAdh = new Adherent();

	// mise à jour des données
	updateAdherentData(newAdh, dataAdherent);

	// enregistrement de l'adherent
	entityManager.persist(newAdh);
	entityManager.flush();

	return newAdh.getId();
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
    public void createContactAdherent(AdherentContactRole contact) {
	AdherentContactRole newData = new AdherentContactRole();
	newData.setAdherent(contact.getAdherent());
	newData.setCivilite(contact.getCivilite());
	newData.setFixe(contact.getFixe());
	newData.setMail(contact.getMail());
	newData.setMobile(contact.getMobile());
	newData.setNaissance(contact.getNaissance());
	newData.setNom(contact.getNom());
	newData.setPhoto(contact.getPhoto());
	newData.setPrenom(contact.getPrenom());
	newData.setFonction(contact.getFonction());

	entityManager.persist(newData);

    }

    @Override
    @Transactional
    public void createContactFonction(String libelle) {
	ContactFonction newData = new ContactFonction();
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

    @Override
    public String loadAdherentCommentaire(int idAdh, PageType type) {
	try {
	    AdherentCommentaire cmm = loadAdherentPageCommentaire(idAdh, type);

	    return cmm == null ? "" : cmm.getCommentaireString();
	} catch (NoResultException e) {
	    return "";
	}
    }

    /**
     * Création d'une liste avec tout les type de contacte
     */
//    @Override
//    public Map<TypeContact, List<AdherentContact>> loadAdherentContact(int adhId) {
//
//	Map<TypeContact, List<AdherentContact>> map = new HashMap<>();
//
//	List<TypeContact> typeContact = entityManager
//		.createQuery("from TypeContact order by libelle", TypeContact.class).getResultList();
//	final List<AdherentContact> contactsAdh = entityManager
//		.createQuery("from AdherentContact ac where adherent.id = :idAdh ", AdherentContact.class)
//		.setParameter("idAdh", adhId).getResultList();
//
//	typeContact.stream().forEach(t -> map.put(t,
//		contactsAdh.stream().filter(f -> f.getType().getId() == t.getId()).collect(Collectors.toList())));
//
//	return new TreeMap<>(map);
//    }

    /**
     * Création d'une liste avec tout les type de contacte
     */
    @Override
    public List<AdherentContactRole> loadAdherentContact(int adhId) {

	List<AdherentContactRole> contacts = entityManager
		.createQuery("from AdherentContactRole where adherent.id = :adhId", AdherentContactRole.class)
		.setParameter("adhId", adhId).getResultList();

	return contacts;
    }

    private AdherentCommentaire loadAdherentPageCommentaire(int idAdh, PageType type) {
	try {
	    return entityManager
		    .createQuery("from AdherentCommentaire com where adherentId = :adhId and type = :type",
			    AdherentCommentaire.class)
		    .setParameter("adhId", idAdh).setParameter("type", type).getSingleResult();

	} catch (NoResultException e) {
	    return null;
	}
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
	    boolean isActif = criteria.getShowAll() ? true : adh.getEtat().getId() == 1;

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
    public List<ContactFonction> loadContactFonction() {
	return entityManager.createQuery("from ContactFonction", ContactFonction.class).getResultList();
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

    @Transactional
    @Override
    public void saveAdherentCommentaire(int adhId, PageType type, String commentaire) {

	AdherentCommentaire adhCommentaire = loadAdherentPageCommentaire(adhId, type);
	if (adhCommentaire == null) {
	    adhCommentaire = new AdherentCommentaire();
	    adhCommentaire.setAdherentId(adhId);
	    adhCommentaire.setType(type);
	    adhCommentaire.setCommentaireString(commentaire);
	} else {
	    adhCommentaire.setCommentaireString(commentaire);
	}

	entityManager.persist(adhCommentaire);

    }

    @Override
    @Transactional
    public void saveAdherentContacts(List<AdherentContactRole> contacts) {

	// Pour tout les contact de la liste
	contacts.stream().forEach(c -> {
	    AdherentContactRole adhContact = c.getId() == null ? new AdherentContactRole()
		    : entityManager.find(AdherentContactRole.class, c.getId());
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
    public void saveContactsFonctions(List<ContactFonction> contactFonctions) {
	// Pour tout les contact de la liste
	contactFonctions.stream().forEach(a -> {
	    ContactFonction contactFonction = a.getId() == null ? new ContactFonction()
		    : entityManager.find(ContactFonction.class, a.getId());
	    contactFonction.setLibelle(a.getLibelle());
	    entityManager.persist(contactFonction);
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
    @Transactional
    public void saveSecteurs(List<Secteur> secteurs) {
	// Pour tout les contact de la liste
	secteurs.stream().forEach(a -> {
	    Secteur secteur = a.getId() == null ? new Secteur() : entityManager.find(Secteur.class, a.getId());
	    secteur.setLibelle(a.getLibelle());
	    entityManager.persist(secteur);
	});
    }

    @Override
    @Transactional
    public void setAdherentImage(int adhId, byte[] photo) {
	Adherent adh = loadAdherent(adhId);
	adh.setPhoto(photo);

	entityManager.persist(adh);

    }

    @Override
    @Transactional
    public void setContactImage(int contactId, byte[] photo) {

	try {
	    AdherentContactRole contact = entityManager.find(AdherentContactRole.class, contactId);
	    contact.setPhoto(photo);
	    entityManager.persist(contact);

	} catch (NoResultException e) {
	}

    }

    @Override
    @Transactional
    public void supprimeActivite(Integer id) {
	Activite del = entityManager.find(Activite.class, id);
	entityManager.remove(del);
    }

    @Override
    @Transactional
    public void supprimeAdherentContact(Integer id) {
	AdherentContactRole del = entityManager.find(AdherentContactRole.class, id);
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
    public void supprimeContactFonction(Integer id) {
	ContactFonction del = entityManager.find(ContactFonction.class, id);
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

    private AdherentContactRole updateAdherentContactData(AdherentContactRole dbbContact,
	    AdherentContactRole adhContact) {

	dbbContact.setAdherent(adhContact.getAdherent());
	dbbContact.setCivilite(adhContact.getCivilite());
	dbbContact.setFixe(adhContact.getFixe());
	dbbContact.setFonction(adhContact.getFonction());
	dbbContact.setIsAdministratif(adhContact.getIsAdministratif());
	dbbContact.setIsCommerce(adhContact.getIsCommerce());
	dbbContact.setIsCompta(adhContact.getIsCompta());
	dbbContact.setIsDirigeant(adhContact.getIsDirigeant());
	dbbContact.setMail(adhContact.getMail());
	dbbContact.setMobile(adhContact.getMobile());
	dbbContact.setNaissance(adhContact.getNaissance());
	dbbContact.setNom(adhContact.getNom());
	dbbContact.setPhoto(adhContact.getPhoto());
	dbbContact.setPrenom(adhContact.getPrenom());

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