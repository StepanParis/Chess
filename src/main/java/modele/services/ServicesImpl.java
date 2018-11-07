package modele.services;

import modele.Joueur;
import modele.Partie;
import modele.exception.*;
import modele.persistence.DAOJoueur;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServicesImpl implements AdministrationService, GestionInteractionPartieService,
        GestionPartieService{

    private Map<String, Joueur> joueursInscrits;
    private Collection<String> joueursConnectes;
    private Map<Long, Partie> lesParties;
    DAOJoueur daoJoueur = new DAOJoueur();

    public ServicesImpl() {
        joueursInscrits = new HashMap<String, Joueur>();
        joueursConnectes = new HashSet<String>();
        lesParties = new HashMap<Long, Partie>();
    }

    public void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException, SQLException {

        if (pseudo == null || motDePasse == null || confirmationMotDePasse == null) { throw new DonneesException(); }
        if (!motDePasse.equals(confirmationMotDePasse)) { throw new ConfirmationMDPException(); }
        //if (joueursInscrits.containsKey(pseudo)) { throw new PseudoDejaPrisException(); }
        if (daoJoueur.findByPseudo(pseudo)!=null) { throw new PseudoDejaPrisException(); }

        Joueur nouveauJoueur = Joueur.creerJoueur(pseudo, motDePasse);
        daoJoueur.create(nouveauJoueur);
        //joueursInscrits.put(pseudo, nouveauJoueur);
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

    public void desabonnement(String pseudo, String motDePasse) throws DonneesException, SQLException {

        if (pseudo == null || motDePasse == null) { throw new DonneesException(); }
        if (daoJoueur.findByPseudo(pseudo)==null) { throw new DonneesException(); }

        Joueur joueur = Joueur.creerJoueur(pseudo, motDePasse);
        daoJoueur.delete(joueur);
    }


    private void estConnecte(String pseudo) throws PseudoNonConnecteException {
        if (!joueursConnectes.contains(pseudo)) throw new PseudoNonConnecteException();
    }

    private void pasImpliqueDansUnePartie(String pseudo) throws DejaImpliqueDansUnePartie {
        Joueur joueur = joueursInscrits.get(pseudo);
        for (Partie p: this.lesParties.values()) {
            if (p.getJoueurs().contains(joueur)) { throw new DejaImpliqueDansUnePartie(); }
        }
    }

    public long creerUnePartie(String pseudo) throws DejaImpliqueDansUnePartie, PseudoNonConnecteException {
        this.estConnecte(pseudo);
        this.pasImpliqueDansUnePartie(pseudo);
        Partie partie = Partie.creerPartie(joueursInscrits.get(pseudo));
        this.lesParties.put(partie.getId(), partie);
        return partie.getId();
    }

    public void rejoindUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException,
            DejaImpliqueDansUnePartie, PartiePleineException{
        this.estConnecte(pseudo);
        this.pasImpliqueDansUnePartie(pseudo);
        Partie partie = this.lesParties.get(idPartieConcernee);
        if (partie.getJoueurs().size() == 2) throw new PartiePleineException();
        else partie.ajouterJoueur(joueursInscrits.get(pseudo));
    }

    public void quitterUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException {



    }

    public Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws PseudoNonConnecteException {
        return null;
    }

    public Collection<Partie> getPartiesEnCours(String pseudo) throws PseudoNonConnecteException {
        return null;
    }

    public Partie getPartieById(String pseudo, long idPartie) throws PseudoNonConnecteException {
        return null;
    }

    public void rejoindUnePartie() {

    }
}

