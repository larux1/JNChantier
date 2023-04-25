package dao;

import java.sql.*;



public class SingletonConnexionDB {
    private static Connection connection;
    static {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jn_chantier", "root", "");
		    System.out.println("Connexion réussie.");
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    
    
    public Connection getConnexion(){
        return connection;
    }
}
