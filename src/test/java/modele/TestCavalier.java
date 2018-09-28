package modele;

import org.junit.Assert;
import org.junit.Test;

public class TestCavalier {

    /*
    On veut deplacer le cavalier mais la case est occupée par une pièce de la même couleur
     */
    @Test
    public void testDeplacementImpossible1(){

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

        Cavalier cavalier = new Cavalier(null,CouleurPiece.NOIRE);

        Assert.assertFalse(cavalier.deplacementValide(Case.getCase('b', 3), 'a', 5));

    }

    /*
    On veut deplacer le cavalier mais la case est occupée par une pièce adverse
     */
    @Test
    public void testDeplacementPossible1(){

        QuestionnerPlateau plateau = new QuestionnerPlateau() {
            public boolean caseOccupeePar(CouleurPiece couleurPiece, Case caseP) {
                Case a5 = Case.getCase('a', 5);
                if ((caseP == a5) && couleurPiece == CouleurPiece.BLANCHE) {
                    return true;
                }
                return false;
            }

            public boolean pieceNonMenacee(CouleurPiece couleur, Case aCase) {
                return false;
            }
        };

        Cavalier cavalier = new Cavalier(null,CouleurPiece.NOIRE);

        Assert.assertTrue(cavalier.deplacementValide(Case.getCase('b', 3), 'a', 5));

    }

    /*
    On veut deplacer le cavalier mais la case est innaccessible
     */
    public void testDeplacementPossible2(){

        QuestionnerPlateau plateau = new QuestionnerPlateau() {
            public boolean caseOccupeePar(CouleurPiece couleurPiece, Case caseP) {
                return false;
            }

            public boolean pieceNonMenacee(CouleurPiece couleur, Case aCase) {
                return false;
            }
        };

        Cavalier cavalier = new Cavalier(plateau,CouleurPiece.NOIRE);

        Assert.assertFalse(cavalier.deplacementValide(Case.getCase('b', 3), 'c', 12));

    }
}
