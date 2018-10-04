package modele.services;

public interface GestionPartieService {

    long creerUnePartie(String pseud) throws DejaImpliqueDansUnePartie, PseudeNonConnecteExceptio;

    void rejoindUnePartie
}
