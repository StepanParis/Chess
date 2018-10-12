package modele;

public class Tour implements Piece{

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Tour(QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {

        CouleurPiece adversaire = couleur == CouleurPiece.BLANCHE ? CouleurPiece.NOIRE : CouleurPiece.BLANCHE;

        if (aCase.getColumn() == xf){
            for (int i = aCase.getRow(); i <= yf; i++){
                if (plateau.caseOccupeePar(couleur, Case.getCase(xf, i)) ||
                    plateau.caseOccupeePar(adversaire, Case.getCase(xf, i))) return false;
            }
            return true;
        }

        else
            if ((aCase.getRow() == yf)) {
                for (int i = aCase.getColumn(); i < xf; i++){
                    if (plateau.caseOccupeePar(couleur, Case.getCase((char) i, yf)) ||
                        plateau.caseOccupeePar(adversaire, Case.getCase(xf, i))) return false;
                }
                return true;
            }
         return false;
    }

    public CouleurPiece getCouleur() {
        return couleur;
    }
}
