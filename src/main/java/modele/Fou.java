package modele;

public class Fou implements Piece{

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Fou(QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {

        CouleurPiece adversaire = couleur == CouleurPiece.BLANCHE ? CouleurPiece.NOIRE : CouleurPiece.BLANCHE;

        if ((xf - aCase.getRow()) == yf - aCase.getColumn()) {
            if (((xf-aCase.getRow())<0) && ((yf-aCase.getColumn())<0)) {

            }

        }
    }

    public CouleurPiece getCouleur() {
        return null;
    }
}
