package modele.services;

import modele.exception.*;
import org.junit.*;


public class TestGestionPartieServicesImpl {


    GestionPartieService gestionPartieService;
    String               utilisateurConnecte;
    String               utilisateurConnecte2;
    String               utilisateurConnecte3;
    String               utilisateurNonConnecte;
    String               utilisateurNonInscrit;

    public TestGestionPartieServicesImpl() throws PseudoNonConnecteException, DejaImpliqueDansUnePartie {
    }

    @Before
    public void setInformations() {
        ServicesImpl          services = new ServicesImpl();
        AdministrationService admin = services;
        utilisateurConnecte    = "y";
        utilisateurConnecte2   = "a";
        utilisateurConnecte3   = "e";
        utilisateurNonConnecte = "h";
        utilisateurNonInscrit  = "t";
        gestionPartieService   = services;

        try {
            admin.inscription(utilisateurConnecte, utilisateurConnecte, utilisateurConnecte);
            admin.connexion(utilisateurConnecte, utilisateurConnecte);
            admin.inscription(utilisateurConnecte2, utilisateurConnecte2, utilisateurConnecte2);
            admin.connexion(utilisateurConnecte2, utilisateurConnecte2);
            admin.inscription(utilisateurConnecte3, utilisateurConnecte3, utilisateurConnecte3);
            admin.connexion(utilisateurConnecte3, utilisateurConnecte3);
            admin.inscription(utilisateurNonConnecte, utilisateurNonConnecte, utilisateurNonConnecte);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * Test du scénario: de création de partie OK
     * @throws PseudoNonConnecteException
     * @throws DejaImpliqueDansUnePartie
     */
    @Test
    public void testCreerUnePartieOK() throws PseudoNonConnecteException, DejaImpliqueDansUnePartie {
        Long idPartie = gestionPartieService.creerUnePartie(utilisateurConnecte);
        Assert.assertTrue(idPartie != null);
    }

    //Si le joueur n'est pas connecté
    @Test(expected = PseudoNonConnecteException.class )
    public void testCreerUnePartieOK1() throws PseudoNonConnecteException, DejaImpliqueDansUnePartie {
        Long idPartie = gestionPartieService.creerUnePartie(utilisateurNonConnecte);
    }

    //Si le joueur est déjà dans une partie
    @Test(expected = DejaImpliqueDansUnePartie.class)
    public void testCreerUnePartieOK2() throws PseudoNonConnecteException, DejaImpliqueDansUnePartie {
        Long idPartie = gestionPartieService.creerUnePartie(utilisateurConnecte3);
        Long idPartie2 = gestionPartieService.creerUnePartie(utilisateurConnecte3);
    }

//rejoindreUenPartie-----------------------------------------------------------------------------------------------------
    @Test
    public void testRejoindreUnePartieOK() throws PseudoNonConnecteException, DejaImpliqueDansUnePartie,
            PartiePleineException {
        Long idPartie = gestionPartieService.creerUnePartie(utilisateurConnecte);
        gestionPartieService.rejoindUnePartie(utilisateurConnecte2, idPartie);
        Assert.assertTrue(true);
    }

}
