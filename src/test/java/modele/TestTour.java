package modele;

import org.junit.Assert;
import org.junit.Test;

public class TestTour {

    /*
   On veut deplacer le Tour mais la case est occupée par une pièce de la même couleur
    */
    @Test
    public void testDeplecementImposible() {

        QuestionnerPlateau plateau = new QuestionnerPlateau() {
            public boolean caseOccupeePar(CouleurPiece couleurPiece, Case caseP) {
                Case a5 = Case.getCase('a', 5);
                if ((caseP == a5) && couleurPiece == CouleurPiece.NOIRE) {
                    return true;
                }
                return false;
            }

            public boolean pieceNonMenacee(CouleurPiece couleur, Case aCase) {
                return false;
            }
        };


        Tour tour = new Tour(null, CouleurPiece.NOIRE);

        Assert.assertFalse(tour.deplacementValide(Case.getCase('d', 5), 'd', 8));
    }

}