package modele;

public class Fou implements Piece{

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Fou(QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {
        if ((xf - aCase.getRow()) == aCase.getColumn() - yf) {

        }
    }

    public CouleurPiece getCouleur() {
        return null;
    }
}
