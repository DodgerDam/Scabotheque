package fr.scabois.scabotheque.dao;

import java.util.List;
import java.util.Map;

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

public interface IAdherentDAO {

    void createActivite(String libelle);

    void createAdherent(Adherent adherent);

    void createAgence(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    void createTypeContact(String libelle);

    void editAdherent(Adherent pAdherent);

    List<Activite> loadActivites();

    List<Activite> loadActivitesAdherents();

    Adherent loadAdherent(int idAdh);

    Map<TypeContact, AdherentContact> LoadAdherentContact(int adhId);

    List<Adherent> loadAdherents();

    List<Adherent> loadAdherents(CriteriaAdherent criteria);

    List<Agence> loadAgences();

    List<Ape> loadApes();

    List<Commune> loadCommunes();

    List<Etat> loadEtats();

    List<FormeJuridique> loadFormesJuridiques();

    List<Pole> loadPoles();

    List<Role> loadRoles();

    List<Secteur> loadSecteurs();

    List<Tournee> loadTournees();

    List<TypeContact> loadTypeContact();

    void saveAdherentContacts(List<AdherentContact> contacts);

    void saveAgences(List<Agence> agences);

    void savePoles(List<Pole> poles);

    void saveRoles(List<Role> roles);

    void saveSecteur(List<Secteur> secteurs);

    void saveTypeContacts(List<TypeContact> typeContacts);

    void supprimeActivite(Integer id);

    void supprimeAgence(Integer id);

    void supprimePole(Integer id);

    void supprimeRole(Integer id);

    void supprimeSecteur(Integer id);

    void supprimeTypeContact(Integer id);

//    void addAdherents(final Adherent adherent);
//    
//    void deleteAdherent(final Adherent adherent);
//    
//    void editAdherent(final Adherent adherent);
}