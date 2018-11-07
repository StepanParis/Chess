package modele.persistence;

import jdbc.JDBC;
import modele.Joueur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOJoueur {

    public Joueur findByPseudo (String pseudo) throws SQLException {
        PreparedStatement ps = JDBC.getConnexion().prepareStatement("select");
        ps.setString(1, pseudo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Joueur j = Joueur.creerJoueur(rs.getString(1), rs.getString(2));
            return j;
        } else {
            return null;
        }
    }

    public void create(Joueur j) throws SQLException {
        PreparedStatement ps = JDBC.getConnexion().prepareStatement("insert into");

        ps.setString(1, j.getPseudo());
        ps.setString(2, j.getMotDePasse());
        ps.executeUpdate();
    }
}
