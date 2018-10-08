package modele.services;

import modele.exception.*;

public interface GestionPartieService {

    long creerUnePartie(String pseud) throws DejaImpliqueDansUnePartie, PseudeNonConnecteExceptio;

    void rejoindUnePartie();
}
