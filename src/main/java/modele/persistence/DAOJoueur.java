package modele.persistence;

import application.JDBC;
import modele.Joueur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOJoueur {

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

    public void getPassword(Joueur j)
}
