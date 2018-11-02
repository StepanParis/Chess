package modele;

public class Pion implements Piece {

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Pion (QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {
        if (couleur == CouleurPiece.BLANCHE) {
            if ((aCase.getColumn() == xf) && (yf-aCase.getRow()==1)) {
                return !plateau.caseOccupeePar(null, Case.getCase(xf, yf));
            }
            if ((((xf - aCase.getColumn())==1) && (yf - aCase.getRow()==1)) || (((aCase.getColumn() - xf)==1) && (yf - aCase.getRow()==1))) {
                return !plateau.caseOccupeePar(couleur, Case.getCase(xf, yf));
            }
        }
        if (couleur == CouleurPiece.NOIRE) {
            if ((aCase.getColumn() == xf) && (yf-aCase.getRow() == -1)) {
                return !plateau.caseOccupeePar(null, Case.getCase(xf, yf));
            }
            if ((((xf - aCase.getColumn())==1) && (aCase.getRow() - yf ==1)) || (((aCase.getColumn() - xf)==1) && (aCase.getRow() - yf ==1))) {
                return !plateau.caseOccupeePar(couleur, Case.getCase(xf, yf));
            }
        }
        return false;
    }

    public CouleurPiece getCouleur() {
        return null;
    }
}
