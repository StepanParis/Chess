package modele.services;

import modele.Partie;
import modele.exception.*;

import java.rmi.RemoteException;
import java.util.Collection;

public class SRI implements ASR, GIPS, GPS{

    ServicesImpl service = new ServicesImpl();
    public void inscription(String pseudo, String motDePasse, String confirmationMotDePasse) throws
            PseudoDejaPrisException, ConfirmationMDPException, DonneesException, DejaConnecteException, RemoteException {
        service.inscription(pseudo, motDePasse,confirmationMotDePasse);
    }

    public void connexion(String pseudo, String mdp) throws DonneesException, DejaConnecteException,
            ConfirmationMDPException, RemoteException {
        service.connexion(pseudo, mdp);
    }

    public void deconnexion(String pseudo) throws DonneesException, NonConnecteException, RemoteException {
        service.deconnexion(pseudo);
    }

    public void desabonnement(String pseudo, String mdp) throws DonneesException, RemoteException {
        service.desabonnement(pseudo, mdp);
    }

    public long creerUnePartie(String pseudo) throws DejaImpliqueDansUnePartie, PseudoNonConnecteException,
            RemoteException {
        return service.creerUnePartie(pseudo);
    }

    public void rejoindUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException,
            DejaImpliqueDansUnePartie, PartiePleineException, RemoteException {
        service.rejoindUnePartie(pseudo, idPartieConcernee);

    }

    public void quitterUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException,
            RemoteException {
        service.quitterUnePartie(pseudo, idPartieConcernee);

    }

    public Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws PseudoNonConnecteException,
            RemoteException {
        return service.getPartiesEnAttenteDeJoueurs(pseudo);
    }

    public Collection<Partie> getPartiesEnCours(String pseudo) throws PseudoNonConnecteException, RemoteException {
        return service.getPartiesEnCours(pseudo);
    }

    public Partie getPartieById(String pseudo, long idPartie) throws PseudoNonConnecteException, RemoteException {
        return service.getPartieById(pseudo, idPartie);
    }
}
