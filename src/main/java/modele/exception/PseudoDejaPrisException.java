package modele.exception;

public class PseudoDejaPrisException extends Exception {

    public String toString () {
        return "Pseudo est occupé";
    }
}
