package fr.scabois.scabotheque.dao;

import java.util.List;

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

public interface IAdherentDAO {

    void createActivite(String libelle);

    void createAgence(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    List<Activite> loadActivites();

    List<Activite> loadActivitesAdherents();

    Adherent loadAdherent(int idAdh);

    List<Adherent> loadAdherents();

    List<Agence> loadAgences();

    List<Ape> loadApes();

    List<Commune> loadCommunes();

    List<Etat> loadEtats();

    List<FormeJuridique> loadFormesJuridiques();

    List<Pole> loadPoles();

    List<Role> loadRoles();

    List<Secteur> loadSecteurs();

    List<Tournee> loadTournees();

    void saveAdherent(Adherent pAdherent);

    void supprimeActivite(Integer id);

    void supprimeAgence(Integer id);

    void supprimePole(Integer id);

    void supprimeRole(Integer id);

    void supprimeSecteur(Integer id);

//    void addAdherents(final Adherent adherent);
//    
//    void deleteAdherent(final Adherent adherent);
//    
//    void editAdherent(final Adherent adherent);
}