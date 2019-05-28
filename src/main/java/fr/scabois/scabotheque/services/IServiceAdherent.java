package fr.scabois.scabotheque.services;

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

public interface IServiceAdherent {
    void createActivite(String libelle);

    void createAdherent(Adherent dataAdherent);

    void createAgence(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    void createTypeContact(String libelle);

    List<Activite> LoadActivites();

    List<Activite> LoadActivitesAdherents();

    Adherent LoadAdherent(int idAdh);

    Map<TypeContact, AdherentContact> LoadAdherentContact(int adhId);

    List<Adherent> LoadAdherents();

    List<Adherent> LoadAdherents(CriteriaAdherent criteria);

    List<Agence> LoadAgences();

    List<Ape> LoadCodeApes();

    List<Commune> LoadCommunes();

    List<Etat> LoadEtats();

    List<FormeJuridique> LoadFormesJuridiques();

    List<Pole> LoadPoles();

    List<Role> LoadRoles();

    List<Secteur> LoadSecteurs();

    List<Tournee> LoadTournees();

    List<TypeContact> LoadTypeContact();

    void saveAdherent(final Adherent pAdherent);

    void saveAdherentContact(List<AdherentContact> contacts);

    void saveAgence(List<Agence> agences);

    void savePole(List<Pole> setEditList);

    void saveRole(List<Role> setEditList);

    void saveSecteur(List<Secteur> setEditList);

    void saveTypeContact(List<TypeContact> typeContacts);

    void supprimerActivite(Integer id);

    void supprimerAgence(Integer id);

    void supprimerPole(Integer id);

    void supprimerRole(Integer id);

    void supprimerSecteur(Integer id);

    void supprimerTypeContact(Integer id);
}