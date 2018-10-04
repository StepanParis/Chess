package modele.exception;

public class DejaConnecteException extends Exception {

    public String toString () {
        return "Ce joueur est déjà connecté";
    }
}
