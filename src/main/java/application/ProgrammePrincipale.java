package application;

import modele.Case;
import modele.services.PointAcces;
import modele.services.SRI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProgrammePrincipale {
    public static void main(String[] args) {

        PointAcces pointAcces = (PointAcces) new SRI();

        try {
            //fabrique le proxy pour le client
            PointAcces stub = (PointAcces) UnicastRemoteObject.exportObject(pointAcces, 0);
            //accés dans l'annuaire
            Registry reg = LocateRegistry.getRegistry("localhost");
            //publie dans l'annuaire
            reg.bind("services", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

/*
        //A8
        Case a8 = Case.getCase('a', 8);

        //B1
        Case b1 = Case.getCase('b', 1);

        //A8
        Case a82 = Case.getCase('a', 8);

        System.out.println(a8 + " =? " + a82);

        System.out.println(a8 + " =? " + b1);

       */
    }
}
