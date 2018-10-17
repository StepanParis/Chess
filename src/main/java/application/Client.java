package application;

import modele.exception.ConfirmationMDPException;
import modele.exception.DejaConnecteException;
import modele.exception.DonneesException;
import modele.services.PointAcces;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        try {
            //connexion à l'annuaire
            Registry reg = LocateRegistry.getRegistry("localhost");
            //recherche du service
            PointAcces pointAcces = (PointAcces) reg.lookup("services");
            //utilisation du service distant
            pointAcces.connexion("Stepan", "345");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DejaConnecteException e) {
            e.printStackTrace();
        } catch (DonneesException e) {
            e.printStackTrace();
        } catch (ConfirmationMDPException e) {
            e.printStackTrace();
        } catch ( NotBoundException e) {
            e.printStackTrace();
        }
    }
}
