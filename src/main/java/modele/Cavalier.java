package modele;

public class Cavalier implements Piece{

    public static final int DISTANCE_CAVALIER = 5;
    QuestionnerPlateau plateau;
    CouleurPiece couleur;

    public Cavalier(QuestionnerPlateau plateau, CouleurPiece couleur) {
        this.plateau = plateau;
        this.couleur = couleur;
    }



    public boolean deplacementValide(Case aCase, char xf, int yf) {
        /*CouleurPiece adversaire = couleur == CouleurPiece.BLANCHE ? CouleurPiece.NOIRE : CouleurPiece.BLANCHE;
        Case caseFinale = Case.getCase(xf,yf);

        if (plateau.caseOccupeePar(adversaire, caseFinale))
            return false;
        else
            if (caseFinale.equals(Case.getCase((char) (xf - 1), yf + 2)) ||
                 caseFinale.equals(Case.getCase((char) (xf + 1), yf + 2)) ||
                 caseFinale.equals(Case.getCase((char) (xf - 1), yf - 2)) ||
                 caseFinale.equals(Case.getCase((char) (xf + 1), yf - 2)) ||
                 caseFinale.equals(Case.getCase((char) (xf + 2), yf + 1)) ||
                 caseFinale.equals(Case.getCase((char) (xf + 2), yf - 1)) ||
                 caseFinale.equals(Case.getCase((char) (xf - 2), yf + 1)) ||
                 caseFinale.equals(Case.getCase((char) (xf - 2), yf + 1)))
            {
                return true;
            }

            return false;
    }*/
        Case caseDestination = Case.getCase(xf, yf);
        int deltaX = (int) xf;
        int deltaY = yf;

        int dd = deltaX * deltaX + deltaY * deltaY;
        if (dd == DISTANCE_CAVALIER) {
            return plateau.caseOccupeePar(couleur, caseDestination);
        } else
            return false;
    }


    public CouleurPiece getCouleur() {
        return couleur;
    }

}
