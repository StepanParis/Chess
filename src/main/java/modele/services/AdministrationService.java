package modele.services;

import modele.exception.*;

public interface AdministrationService {

    void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException,DonneesException, DejaConnecteException;

    void connexion(String pseudo,String mdp) throws DonneesException, DejaConnecteException, ConfirmationMDPException;

    void deconnexion(String pseudo) throws DonneesException;

    void desabonnement(String pseudo,String mdp) throws DonneesException;
}

