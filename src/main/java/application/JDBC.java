package application;

import modele.persistance.DAOJoueur;

import java.sql.*;


public class JDBC {

    private Connection c;
    private static JDBC single=null;

    public static JDBC getSingleton(){
        if(single==null){
            try{
                single=new JDBC();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return single;
    }

    private JDBC() throws SQLException {
        TestConnection();
    }

    public static void main(String[] args) throws SQLException {
        JDBC jdbc = new JDBC();
    }

    public static Connection connection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://dbhost:3306/bd_o2174734","o2174734", "o2174734");
    }

    public static void TestConnection() throws SQLException {
        Connection connection = connection();

        Statement s = connection.createStatement();

        ResultSet rs=s.executeQuery( "SELECT pseudo, password FROM `UTILISATEUR`");

        DAOJoueur daoJoueur = new DAOJoueur();
        daoJoueur.findByPseudo("Tom");

        /*while (rs.next()) {
            System.out.println(rs.getString(1)+ " "
                    +rs.getString(2)) ;
        }*/
    }




}


