package fr.scabois.scabotheque.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import fr.scabois.scabotheque.dao.IAdherentDAO;

@Service
public class ServiceAdherent implements IServiceAdherent {

    @Autowired
    private IAdherentDAO dao;

    @Override
    public void createActivite(String libelle) {
	dao.createActivite(libelle);
    }

    @Override
    public void createAdherent(Adherent datatAdherent) {
	dao.createAdherent(datatAdherent);
    }

    @Override
    public void createAgence(String libelle) {
	dao.createAgence(libelle);

    }

    @Override
    public void createPole(String libelle) {
	dao.createPole(libelle);
    }

    @Override
    public void createRole(String libelle) {
	dao.createRole(libelle);
    }

    @Override
    public void createSecteur(String libelle) {
	dao.createSecteur(libelle);
    }

    @Override
    public void createTypeContact(String libelle) {
	dao.createTypeContact(libelle);
    }

    @Override
    public List<Activite> LoadActivites() {
	return dao.loadActivites();
    }

    @Override
    public List<Activite> LoadActivitesAdherents() {
	return dao.loadActivitesAdherents();
    }

    @Override
    public Adherent LoadAdherent(int idAdh) {
	return dao.loadAdherent(idAdh);
    }

    @Override
    public Map<TypeContact, AdherentContact> LoadAdherentContact(int adhId) {
	return dao.LoadAdherentContact(adhId);
    }

    // @Transactional(readOnly=true)
    @Override
    public List<Adherent> LoadAdherents() {
	return dao.loadAdherents();
    }

    @Override
    public List<Adherent> LoadAdherents(CriteriaAdherent criteria) {
	return dao.loadAdherents(criteria);
    }

    @Override
    public List<Agence> LoadAgences() {
	return dao.loadAgences();
    }

    @Override
    public List<Ape> LoadCodeApes() {
	return dao.loadApes();
    }

    @Override
    public List<Commune> LoadCommunes() {
	return dao.loadCommunes();
    }

    @Override
    public List<Etat> LoadEtats() {
	return dao.loadEtats();
    }

    @Override
    public List<FormeJuridique> LoadFormesJuridiques() {
	return dao.loadFormesJuridiques();
    }

    @Override
    public List<Pole> LoadPoles() {
	return dao.loadPoles();
    }

    @Override
    public List<Role> LoadRoles() {
	return dao.loadRoles();
    }

    @Override
    public List<Secteur> LoadSecteurs() {
	return dao.loadSecteurs();
    }

    @Override
    public List<Tournee> LoadTournees() {
	return dao.loadTournees();
    }

    @Override
    public List<TypeContact> LoadTypeContact() {
	return dao.loadTypeContact();
    }

    @Override
    public void saveAdherent(Adherent pAdherent) {
	dao.editAdherent(pAdherent);
    }

    @Override
    public void saveAdherentContact(List<AdherentContact> contacts) {
	dao.saveAdherentContacts(contacts);
    }

    @Override
    public void saveAgence(List<Agence> agences) {
	dao.saveAgences(agences);

    }

    @Override
    public void savePole(List<Pole> poles) {
	dao.savePoles(poles);
    }

    @Override
    public void saveRole(List<Role> roles) {
	dao.saveRoles(roles);
    }

    @Override
    public void saveSecteur(List<Secteur> secteurs) {
	dao.saveSecteur(secteurs);
    }

    @Override
    public void saveTypeContact(List<TypeContact> typeContacts) {
	dao.saveTypeContacts(typeContacts);
    }

    @Override
    public void supprimerActivite(Integer id) {
	dao.supprimeActivite(id);
    }

    @Override
    public void supprimerAgence(Integer id) {
	dao.supprimeAgence(id);
    }

    @Override
    public void supprimerPole(Integer id) {
	dao.supprimePole(id);
    }

    @Override
    public void supprimerRole(Integer id) {
	dao.supprimeRole(id);
    }

    @Override
    public void supprimerSecteur(Integer id) {
	dao.supprimeSecteur(id);
    }

    @Override
    public void supprimerTypeContact(Integer id) {
	dao.supprimeTypeContact(id);
    }

}