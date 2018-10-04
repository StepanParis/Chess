package modele.exception;

public class ConfirmationMDPException extends Exception {

    public String toString () {
        return "Mot de passe n'est pas correcte";
    }

}
