package jdbc;

import java.sql.*;

public class JDBC {

    public static Connection getConnexion () throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://bdhost:3306/bd_02174734", "02174734", "02174734");
    }

    private static JDBC single=null;
    public static JDBC getSingleton() {
        if (single == null) {
            try {
                single=new JDBC();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return single;
    }

    public JDBC() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://bdhost:3306/bd_02174734", "02174734", "02174734");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM UTILISATEUR");
        while (rs.next()){
            System.out.println("Pseudo d'utilisateur: " + rs.getString(2));
        }
    }



}
