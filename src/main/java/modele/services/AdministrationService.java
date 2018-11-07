package modele.services;

import modele.exception.*;

import java.sql.SQLException;

public interface AdministrationService {

    void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException, DejaConnecteException, SQLException;

    void connexion(String pseudo,String mdp) throws DonneesException, DejaConnecteException, ConfirmationMDPException;

    void deconnexion(String pseudo) throws DonneesException, NonConnecteException;

    void desabonnement(String pseudo,String mdp) throws DonneesException;
}

