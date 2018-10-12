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
    private int idJoueur = 1;

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

    public void ajouterJoueur(Joueur joueur) throws PartiePleineException {
        if (idJoueur == 1) {
            idJoueur = 2;
            joueurs.put(joueur, CouleurPiece.BLANCHE);
        }
        else if (idJoueur == 2) {
            idJoueur = 1;
            joueurs.put(joueur, CouleurPiece.NOIRE);
        }
    }

    public Collection<Joueur> getJoueurs() {
        return joueurs.keySet();
    }

    public long getId() {
        return id;
    }
}
