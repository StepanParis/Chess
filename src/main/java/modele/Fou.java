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

        if (Math.abs((int)aCase.getColumn() - (int)xf) == Math.abs(aCase.getRow() - yf)) {

            if (((aCase.getRow() - yf) > 0) && ((aCase.getColumn() - xf)) < 0) {
                for (int i = 1; i <= aCase.getRow() - yf; i++) {
                    return !plateau.caseOccupeePar(couleur, Case.getCase((char)(aCase.getColumn()+1), aCase.getRow()-1)) &&
                           !plateau.caseOccupeePar(adversaire, Case.getCase((char)(aCase.getColumn()+1), aCase.getRow()-1));
                }
            }
            if (((aCase.getRow() - yf) < 0) && ((aCase.getColumn() - xf)) > 0) {
                for (int i = 1; i <= yf - aCase.getRow(); i++) {
                    return !plateau.caseOccupeePar(couleur, Case.getCase((char)(aCase.getColumn()-1), aCase.getRow()+1)) &&
                            !plateau.caseOccupeePar(adversaire, Case.getCase((char)(aCase.getColumn()-1), aCase.getRow()+1));
                }
            }
            if (((aCase.getRow() - yf) > 0) && ((aCase.getColumn() - xf)) > 0) {
                for (int i = 1; i <= aCase.getRow() - yf; i++) {
                    return !plateau.caseOccupeePar(couleur, Case.getCase((char)(aCase.getColumn()-1), aCase.getRow()-1)) &&
                            !plateau.caseOccupeePar(adversaire, Case.getCase((char)(aCase.getColumn()-1), aCase.getRow()-1));
                }
            }
            if (((aCase.getRow() - yf) < 0) && ((aCase.getColumn() - xf)) < 0) {
                for (int i = 1; i <= aCase.getRow() - yf; i++) {
                    return !plateau.caseOccupeePar(couleur, Case.getCase((char)(aCase.getColumn()+1), aCase.getRow()+1)) &&
                            !plateau.caseOccupeePar(adversaire, Case.getCase((char)(aCase.getColumn()+1), aCase.getRow()+1));
                }
            }
        }
        return false;
    }

    public CouleurPiece getCouleur() { return couleur; }
}
