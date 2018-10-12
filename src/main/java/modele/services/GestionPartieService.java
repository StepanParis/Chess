package modele.services;

import modele.Partie;
import modele.exception.*;

import java.util.Collection;

public interface GestionPartieService {

    long creerUnePartie(String pseudo) throws DejaImpliqueDansUnePartie, PseudoNonConnecteException;

    void rejoindUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException, DejaImpliqueDansUnePartie, PartiePleineException;

    void quitterUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException;

    Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws
            PseudoNonConnecteException;

    Collection<Partie> getPartiesEnCours(String pseudo) throws
            PseudoNonConnecteException;


    Partie getPartieById(String pseudo, long idPartie) throws
            PseudoNonConnecteException;

}
