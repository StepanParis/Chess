package jdbc;

import java.sql.*;

public class JDBC {

    public JDBC() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://bdhost:3306/", "02174734", "02174734");

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM UTILISATEUR");

        while (rs.next()){
            System.out.println("Pseudo d'utilisateur: " + rs.getString(2));
        }
    }



}
