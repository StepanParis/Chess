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

        if (aCase.getColumn() == xf && aCase.getRow() < yf){
            for (int i = aCase.getRow(); i <= yf; i++){
                return  !(plateau.caseOccupeePar(couleur, Case.getCase(xf, i)) &&
                        !plateau.caseOccupeePar(adversaire, Case.getCase(xf, i)));
            }
        }
        if (aCase.getColumn() == xf && aCase.getRow() > yf){
            for (int i = aCase.getRow(); i >= yf; i--){
                return  !(plateau.caseOccupeePar(couleur, Case.getCase(xf, i)) &&
                        !plateau.caseOccupeePar(adversaire, Case.getCase(xf, i)));
            }
        }
        if (aCase.getRow() == yf && aCase.getColumn() < xf) {
            for (int i = aCase.getColumn(); i <= xf; i++){
                return  !(plateau.caseOccupeePar(couleur, Case.getCase((char) i, yf)) &&
                        !plateau.caseOccupeePar(adversaire, Case.getCase((char) i, yf)));
            }
        }
        if (aCase.getRow() == yf && aCase.getColumn() > xf) {
            for (int i = aCase.getColumn(); i >= xf; i--){
                return  !(plateau.caseOccupeePar(couleur, Case.getCase((char) i, yf)) &&
                        !plateau.caseOccupeePar(adversaire, Case.getCase((char) i, yf)));
            }
        }
         return false;
    }

    public CouleurPiece getCouleur() {
        return couleur;
    }
}
