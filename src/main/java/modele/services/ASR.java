package modele.services;

import modele.exception.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ASR extends Remote {

    void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException,
            DejaConnecteException, RemoteException, SQLException;

    void connexion(String pseudo, String mdp) throws DonneesException, DejaConnecteException,
            ConfirmationMDPException, RemoteException;

    void deconnexion(String pseudo) throws DonneesException, NonConnecteException, RemoteException;

    void desabonnement(String pseudo, String mdp) throws DonneesException, RemoteException, SQLException;
}

