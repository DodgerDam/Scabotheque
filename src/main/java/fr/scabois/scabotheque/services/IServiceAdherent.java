package fr.scabois.scabotheque.services;

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

public interface IServiceAdherent {
    void createActivite(String libelle);

    int createAdherent(Adherent dataAdherent);

    void createAgence(String libelle);

    void createContactAdherent(AdherentContactRole contact);

    void createContactFonction(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    List<Activite> LoadActivites();

    List<Activite> LoadActivitesAdherents();

    Adherent LoadAdherent(int idAdh);

    String LoadAdherentCommentaire(int idAdh, PageType pageType);

//    Map<TypeContact, List<AdherentContact>> LoadAdherentContact(int adhId);
    List<AdherentContactRole> LoadAdherentContact(int adhId);

    List<Adherent> LoadAdherents();

    List<Adherent> LoadAdherents(CriteriaAdherent criteria);

    List<Agence> LoadAgences();

    List<Ape> LoadCodeApes();

    List<Commune> LoadCommunes();

    List<ContactFonction> LoadContactFonctions();

    List<Etat> LoadEtats();

    List<FormeJuridique> LoadFormesJuridiques();

    List<Pole> LoadPoles();

    List<Role> LoadRoles();

    List<Secteur> LoadSecteurs();

    List<Tournee> LoadTournees();

    void saveAdherent(final Adherent pAdherent);

    void saveAdherentCommentaire(int adhId, PageType type, String commentaire);

    void saveAdherentContacts(List<AdherentContactRole> contacts);

    void saveAgences(List<Agence> agences);

    void saveContactFonctions(List<ContactFonction> contactFonctions);

    void savePoles(List<Pole> setEditList);

    void saveRoles(List<Role> setEditList);

    void saveSecteurs(List<Secteur> setEditList);

    void setAdherentImage(int adhId, byte[] bytes);

    void setContactImage(int contactId, byte[] bytes);

    void supprimeActivite(Integer id);

    void supprimeAdherentContact(Integer id);

    void supprimeAgence(Integer id);

    void supprimeContactFonction(Integer id);

    void supprimePole(Integer id);

    void supprimeRole(Integer id);

    void supprimeSecteur(Integer id);
}