package modele.services;

import modele.exception.*;
import org.junit.*;

import java.sql.SQLException;

public class TestServicesImpl {

//Test pour la connexion -----------------------------------------------------------------------------------------------
    @Test
    public void testInscriptionOK() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Step", "456", "456");
        Assert.assertTrue(true);
    }

    @Test(expected = ConfirmationMDPException.class)
    public void testInscriptiOK1() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","123");
    }

    @Test(expected = PseudoDejaPrisException.class)
    public void testInscription0K2() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.inscription("Stepan","789","789");
    }

    @Test(expected = DonneesException.class)
    public void testInscriptionOK3() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription(null,"456","456");
    }

    @Test(expected = DonneesException.class)
    public void testInscription0K4() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456",null);
    }

    @Test(expected = DonneesException.class)
    public void testInscription0K5() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan",null,"456");
    }

//Test pour la connexion ------------------------------------------------------------------------------------------------
    @Test
    public void testConnexionOK() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("Stepan","456");
        Assert.assertTrue(true);
    }

    @Test(expected = DonneesException.class)
    public void testConnexion0K1() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("bob","789");
    }

    @Test(expected = ConfirmationMDPException.class)
    public void testConnexion0K2() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("Stepan","789");
    }

    @Test(expected = DonneesException.class)
    public void testConnexion0K3() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion(null,"456");
    }

    @Test(expected = DejaConnecteException.class)
    public void testConnexion0K4() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("Stepan","456");
        administrationService.connexion("Stepan","456");
    }

////Test pour la déconnexion -------------------------------------------------------------------------------------------
    @Test
    public void testDeconnexionOK() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, NonConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("Stepan","456");
        administrationService.deconnexion("Stepan");
        Assert.assertTrue(true);
    }

    @Test(expected = NonConnecteException.class)
    public void testDeconnexionOK1() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, NonConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.deconnexion("Stepan");
    }

    @Test(expected = DonneesException.class)
    public void testDeconnexionOK2() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException, NonConnecteException, SQLException {
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("Stepan","456","456");
        administrationService.connexion("Stepan","456");
        administrationService.deconnexion(null);
    }


}
