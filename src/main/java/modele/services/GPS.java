package modele.services;

import modele.Partie;
import modele.exception.DejaImpliqueDansUnePartie;
import modele.exception.PartiePleineException;
import modele.exception.PseudoNonConnecteException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface GPS extends Remote {

    long creerUnePartie(String pseudo) throws DejaImpliqueDansUnePartie, PseudoNonConnecteException, RemoteException;

    void rejoindUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException,
            DejaImpliqueDansUnePartie, PartiePleineException, RemoteException;

    void quitterUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException, RemoteException;

    Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws
            PseudoNonConnecteException, RemoteException;

    Collection<Partie> getPartiesEnCours(String pseudo) throws
            PseudoNonConnecteException, RemoteException;


    Partie getPartieById(String pseudo, long idPartie) throws
            PseudoNonConnecteException, RemoteException;

}
