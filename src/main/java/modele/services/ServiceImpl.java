package modele.services;

import modele.Joueur;
import modele.exception.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServiceImpl implements AdministrationService, GestionInteractionPartieService,
        GestionPartieService{

    private Map<String, Joueur> joueursInscrits;
    private Collection<String> joueursConnectes;

    public ServiceImpl () {
        joueursInscrits = new HashMap<String, Joueur>();
        joueursConnectes = new HashSet<String>();
    }


    public void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException {

        if (pseudo == null || motDePasse == null || confirmationMotDePasse == null) { throw new DonneesException(); }
        if (!motDePasse.equals(confirmationMotDePasse)) { throw new ConfirmationMDPException(); }
        if (joueursInscrits.containsKey(pseudo)) { throw new PseudoDejaPrisException(); }

        Joueur nouveauJoueur = Joueur.creerJoueur(pseudo, motDePasse);
        joueursInscrits.put(pseudo, nouveauJoueur);
    }


    public void connexion(String pseudo, String mdp) throws DonneesException, DejaConnecteException,
            ConfirmationMDPException {

        if (pseudo == null || mdp == null) { throw new DonneesException(); }
        if (joueursConnectes.contains(pseudo)) { throw  new DejaConnecteException(); }
        if (!joueursInscrits.containsKey(pseudo)) { throw new DonneesException(); }
        if (!joueursInscrits.get(pseudo).isMDPOK(mdp)) { throw new ConfirmationMDPException(); }

        joueursConnectes.add(pseudo);
    }

    public void deconnexion(String pseudo) throws DonneesException, NonConnecteException {

        if (pseudo == null) { throw new DonneesException(); }
        if (!joueursConnectes.contains(pseudo)) { throw new NonConnecteException(); }

        joueursConnectes.remove(pseudo);
    }

    public void desabonnement(String pseudo, String mdp) throws DonneesException {

        if (pseudo == null) { throw new DonneesException(); }
    }

    public long creerUnePartie(String pseud) throws DejaImpliqueDansUnePartie, PseudeNonConnecteExceptio {
        return 0;
    }

    public void rejoindUnePartie() {

    }
}

