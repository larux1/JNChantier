package dao.capteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnexionDB;
import entities.Capteur;
import entities.Intervenant;

public class CapteurDmpl implements CapteurDAO{

	@Override
	public List<Capteur> findAll() throws SQLException {
		   List<Capteur> capteurs = new ArrayList<>();
	        try {
	            Connection connection=new SingletonConnexionDB().getConnexion();
	            PreparedStatement pstm=connection.prepareStatement("select * from capteur");
	            ResultSet rs=pstm.executeQuery();
	            while (rs.next()){
	                Capteur c=new Capteur();
	                c.setId(rs.getInt("ID"));
	                c.setValeur(rs.getInt("VALEUR"));
	                c.setDate(rs.getString("DATE"));

	              

	                capteurs.add(c);
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        return capteurs;
	    }

	@Override
	public Capteur findOne(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public Capteur save(Capteur capteur, int i) throws SQLException { Connection
	 * connection=new SingletonConnexionDB().getConnexion(); String query =
	 * "INSERT INTO capteur (id, valeur, date) VALUES (?, ?, ?)"; try
	 * (PreparedStatement pstmt = connection.prepareStatement(query)) {
	 * pstmt.setInt(1, capteur.getId()+i+20); pstmt.setInt(2, capteur.getValeur());
	 * pstmt.setString(3, capteur.getDate()); pstmt.executeUpdate(); } return
	 * capteur; }
	 */

	@Override
	public boolean delete(Capteur o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	 @Override
	    public Capteur update(Capteur capteur) throws SQLException {
         Connection connection=new SingletonConnexionDB().getConnexion();   
		 String query = "UPDATE capteur SET valeur = ?, date = ? WHERE id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setInt(1, capteur.getValeur());
	            pstmt.setString(2, capteur.getDate());
	            pstmt.setInt(3, capteur.getId());
	            pstmt.executeUpdate();
	        }
	        return capteur;
	    }

	@Override
	public Capteur save(Capteur capteur) throws SQLException {
		Connection connection=new SingletonConnexionDB().getConnexion();   
    	String query = "INSERT INTO capteur (id, valeur, date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, capteur.getId());
            pstmt.setInt(2, capteur.getValeur());
            pstmt.setString(3, capteur.getDate());
            pstmt.executeUpdate();
        }
        return capteur;
	}

}
