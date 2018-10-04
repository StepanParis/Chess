package modele;

public class Joueur {

    private String pseudo;
    private String motDePasse;

    Joueur(String pseudo, String motDePasse) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    public static Joueur creerJoueur(String pseudo, String motDePasse) {
        return new Joueur(pseudo, motDePasse);
    }

    public String getPseudo() {
        return pseudo;
    }

    public boolean isMDPOK(String mdp) { return mdp.equals(motDePasse);}
}
