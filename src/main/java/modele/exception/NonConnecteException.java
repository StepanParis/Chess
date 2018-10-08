package modele.exception;

public class NonConnecteException extends Exception {

    public String toString () {
        return "Ce joueur n'est pas connecté";
    }
}
