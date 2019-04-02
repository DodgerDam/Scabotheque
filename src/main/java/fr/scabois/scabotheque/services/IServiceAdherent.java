package fr.scabois.scabotheque.services;

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

public interface IServiceAdherent {
    void createActivite(String libelle);

    void createAgence(String libelle);

    void createPole(String libelle);

    void createRole(String libelle);

    void createSecteur(String libelle);

    List<Activite> LoadActivites();

    List<Activite> LoadActivitesAdherents();

    Adherent LoadAdherent(int idAdh);

    List<Adherent> LoadAdherents();

    List<Agence> LoadAgences();

    List<Ape> LoadCodeApes();

    List<Commune> LoadCommunes();

    List<Etat> LoadEtats();

    List<FormeJuridique> LoadFormesJuridiques();

    List<Pole> LoadPoles();

    List<Role> LoadRoles();

    List<Secteur> LoadSecteurs();

    List<Tournee> LoadTournees();

    // void addAdherent(final String pLibelle, final Integer pQuantite);
//    
//    void deleteAdherent(final Integer pIdAdherent);
//    
    void saveAdherent(final Adherent pAdherent);

    void supprimerActivite(Integer id);

    void supprimerAgence(Integer id);

    void supprimerPole(Integer id);

    void supprimerRole(Integer id);

    void supprimerSecteur(Integer id);
}