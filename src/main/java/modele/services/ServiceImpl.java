package modele.services;

import modele.Joueur;
import modele.exception.ConfirmationMDPException;
import modele.exception.DonneesException;
import modele.exception.PseudoDejaPrisException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServiceImpl implements AdministrationService, GestionInteractionPartieService,
        GestionPartieService{

    private Map<String, Joueur> joueursInscrit;
    private Collection<String> joueursConnectes;

    public ServiceImpl () {
        joueursInscrit = new HashMap<String, Joueur>();
        joueursConnectes = new HashSet<String>();
    }


    public void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException {

        if (pseudo == null || motDePasse == null || confirmationMotDePasse == null) {
            throw new DonneesException();
        }
        if (!motDePasse.equals(confirmationMotDePasse)) {
            throw new ConfirmationMDPException();
        }
        if (joueursInscrit.containsKey(pseudo)) {
            throw new PseudoDejaPrisException();
        }
        Joueur nouveauJoueur = Joueur.creerJoueur(pseudo, motDePasse);
        joueursInscrit.put(pseudo, nouveauJoueur);
    }


    public void connexion(String pseudo, String mdp) throws DonneesException {

    }

    public void deconnexion(String pseudo) {

    }

    public void desabonnement(String pseudo, String mdp) throws DonneesException {

    }
}

