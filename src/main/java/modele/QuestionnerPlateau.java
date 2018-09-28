package modele;

public interface QuestionnerPlateau {
    boolean caseOccupeePar(CouleurPiece couleurPiece, Case caseP);
    boolean pieceNonMenacee(CouleurPiece couleur, Case aCase);

}
