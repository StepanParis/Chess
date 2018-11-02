package modele;

public class Cavalier implements Piece{

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Cavalier(QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {

        Case caseDestination = Case.getCase(xf, yf);

        int dx = Math.abs((int)aCase.getColumn() - (int)xf);
        int dy = Math.abs(aCase.getRow() - yf);
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            return !plateau.caseOccupeePar(couleur, caseDestination);
        }
        else return false;

    }

    public CouleurPiece getCouleur() {
        return couleur;
    }
}
