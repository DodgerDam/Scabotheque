package fr.scabois.scabotheque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // @Transactional(readOnly=true)
    @Override
    public List<Adherent> LoadAdherents() {
	return dao.loadAdherents();
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
    public void saveAdherent(Adherent pAdherent) {
	dao.saveAdherent(pAdherent);
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

}