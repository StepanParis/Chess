package modele;

import modele.exception.*;
import modele.services.AdministrationService;
import modele.services.ServiceImpl;
import org.junit.*;

public class TestServicesImpl {

    @Test
    public void testInscriptionOK() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException {
        AdministrationService administrationService = new ServiceImpl();
        administrationService.inscription("Stepan", "456", "456");
        Assert.assertTrue(true);
    }

    @Test(expected = ConfirmationMDPException.class)
    public void testInscriptiOK1() throws PseudoDejaPrisException,
            DonneesException, ConfirmationMDPException, DejaConnecteException {
        AdministrationService administrationService = new ServiceImpl();
        administrationService.inscription("Stepan","456","123");
    }
}
