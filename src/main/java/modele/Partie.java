package modele;

import modele.exception.PartiePleineException;

import java.security.PublicKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Partie {

    public static final int MAX_JOEURS = 2;
    private long id;
    private Map<Joueur, CouleurPiece> joueurs;
    private Plateau plateauPartie;
    private static long identifiants = 0;

    public static Partie creerPartie(Joueur joueur) {
        Partie p = new Partie();
        try {
            p.ajouterJoueur(joueur);
            return p;
        }catch (PartiePleineException e) { e.printStackTrace();}
        return null;
    }

    private Partie() {
        this.id = identifiants++;
        joueurs = new HashMap<Joueur, CouleurPiece>();
        this.plateauPartie = null;
    }

    public void ajouterJoueur(Joueur joueur) throws PartiePleineException { }

    public Collection<Joueur> getJoueurs() {
        return joueurs.keySet();
    }

    public long getId() {
        return id;
    }
}
