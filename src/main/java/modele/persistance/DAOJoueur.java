package modele.persistance;

import application.JDBC;

import modele.Joueur;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class DAOJoueur {

    private static Logger l = null;

    private static Logger getLogger(String path) {
        if (l==null) {
            l = Logger.getLogger("persistance.DAOJoueur");
            try {
                Handler h = new FileHandler("echecs:log");
                l.addHandler(h);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return l;
    }

    public Joueur findByPseudo (String pseudo) throws SQLException {
        PreparedStatement ps = JDBC.connection().prepareStatement("SELECT pseudo, password FROM `UTILISATEUR`" +
                " WHERE pseudo = ? ");
        ps.setString(1, pseudo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Joueur j = Joueur.creerJoueur(rs.getString(1), rs.getString(2));
            System.out.println(j.getPseudo());
            return j;
        } else {
            return null;
        }
    }

    public void create(Joueur j) throws SQLException {
        PreparedStatement ps = JDBC.connection().prepareStatement("INSERT INTO `UTILISATEUR` VALUES (NULL, ?, ?)");

        ps.setString(1, j.getPseudo());
        ps.setString(2, j.getMotDePasse());
        ps.executeUpdate();
    }

    public void delete(Joueur j) throws SQLException {
        PreparedStatement ps = JDBC.connection().prepareStatement("DELETE FROM `UTILISATEUR` WHERE pseudo = ?");

        ps.setString(1, j.getPseudo());
        ps.executeUpdate();
    }

    public String getPassword(String pseudo) throws SQLException {
        PreparedStatement ps = JDBC.connection().prepareStatement("SELECT password FROM 'UTILISATEUR' WHERE pseudo = ?");

        ps.setString(1, pseudo);
        ps.executeUpdate();
        ResultSet rs = (ResultSet) ps;
        System.out.println(rs.getString(3));
        return rs.getString(3);
    }
}
