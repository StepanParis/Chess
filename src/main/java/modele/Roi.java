package modele;

public class Roi  implements Piece {

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Roi (QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {

        Case caseDestination = Case.getCase(xf, yf);

        if (xf == aCase.getColumn() - 1) {
            if ((yf == aCase.getRow() - 1) || (yf == aCase.getRow()) || (yf == aCase.getRow() +1)) {
                return !plateau.caseOccupeePar(couleur, caseDestination);
            }
        }
        if (xf == aCase.getColumn()) {
            if ((yf == aCase.getRow() - 1) || (yf == aCase.getRow() +1)) {
                return !plateau.caseOccupeePar(couleur, caseDestination);
            }
        }
        if (xf == aCase.getColumn() + 1) {
            if ((yf == aCase.getRow() - 1) || (yf == aCase.getRow()) || (yf == aCase.getRow() +1)) {
                return !plateau.caseOccupeePar(couleur, caseDestination);
            }
        }
        return false;
    }

    public CouleurPiece getCouleur() {
        return couleur;
    }
}
