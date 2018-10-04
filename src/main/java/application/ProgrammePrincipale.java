package application;

import modele.Case;

public class ProgrammePrincipale {
    public static void main(String[] args) {

        //A8
        Case a8 = Case.getCase('a', 8);

        //B1
        Case b1 = Case.getCase('b', 1);

        //A8
        Case a82 = Case.getCase('a', 8);

        System.out.println(a8 + " =? " + a82);

        System.out.println(a8 + " =? " + b1);
    }
}
