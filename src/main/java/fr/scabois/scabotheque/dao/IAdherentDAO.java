package fr.scabois.scabotheque.dao;

import java.util.List;

import fr.scabois.scabotheque.bean.adherent.Adherent;
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

public interface IAdherentDAO {

    void createActivite(String libelle);

    int createAdherent(Adherent adherent);

    void createAgence(String libelle);

    void createContactAdherent(AdherentContactRole contact);

    void createContactFonction(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    void editAdherent(Adherent pAdherent);

    List<Activite> loadActivites();

    List<Activite> loadActivitesAdherents();

    Adherent loadAdherent(int idAdh);

    String loadAdherentCommentaire(int idAdh, PageType type);

//    Map<TypeContact, List<AdherentContact>> loadAdherentContact(int adhId);
    List<AdherentContactRole> loadAdherentContact(int adhId);

    List<Adherent> loadAdherents();

    List<Adherent> loadAdherents(CriteriaAdherent criteria);

    List<Agence> loadAgences();

    List<Ape> loadApes();

    List<Commune> loadCommunes();

    List<ContactFonction> loadContactFonction();

    List<Etat> loadEtats();

    List<FormeJuridique> loadFormesJuridiques();

    List<Pole> loadPoles();

    List<Role> loadRoles();

    List<Secteur> loadSecteurs();

    List<Tournee> loadTournees();

    void saveAdherentCommentaire(int adhId, PageType type, String commentaire);

    void saveAdherentContacts(List<AdherentContactRole> contacts);

    void saveAgences(List<Agence> agences);

    void saveContactsFonctions(List<ContactFonction> contactsFonction);

    void savePoles(List<Pole> poles);

    void saveRoles(List<Role> roles);

    void saveSecteurs(List<Secteur> secteurs);

    void setAdherentImage(int adhId, byte[] photo);

    void setContactImage(int contactId, byte[] bytes);

    void supprimeActivite(Integer id);

    void supprimeAdherentContact(Integer id);

    void supprimeAgence(Integer id);

    void supprimeContactFonction(Integer id);

    void supprimePole(Integer id);

    void supprimeRole(Integer id);

    void supprimeSecteur(Integer id);
}