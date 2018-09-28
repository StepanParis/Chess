package modele;

public interface Piece {
    /**
     aCase  : la case de départ de la pièce
     xf : la colonne d’arrivée de la pièce
     yf : la ligne d’arrivée de la pièce
     */
    boolean deplacementValide(Case aCase, char xf, int yf);
    CouleurPiece getCouleur();

}
