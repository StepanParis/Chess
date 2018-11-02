package modele;

public class Reine implements Piece {

    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Reine (QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }
    public boolean deplacementValide(Case aCase, char xf, int yf) {
        CouleurPiece adversaire = couleur == CouleurPiece.BLANCHE ? CouleurPiece.NOIRE : CouleurPiece.BLANCHE;

        //deplacement pour un fou
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

        //deplacement pour une tour
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
