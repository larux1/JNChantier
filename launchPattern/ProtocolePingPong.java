package launchPattern;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.capteur.CapteurDmpl;
import entities.Capteur;
import servPattern.IContext;
import servPattern.IProtocole;


public class ProtocolePingPong implements IProtocole {
	private Capteur capteur;
	

	public ProtocolePingPong() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Capteur getCapteur() {
		return capteur;
	}


	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}


	public void execute( IContext c , InputStream unInput , OutputStream unOutput ) {
		
		String inputReq;
		BufferedReader is = new BufferedReader(new InputStreamReader(
				unInput));
		PrintStream os = new PrintStream(unOutput);
	    try {
	        String valeurExpediee = "";

	        if ((inputReq = is.readLine()) != null) {
	            System.out.println("Ordre reçu " + inputReq);

	            // Créer un modèle d'expression régulière pour extraire les données
	            Pattern pattern = Pattern.compile(".{4}(\\d+),(\\d+),.{1}(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{6})");
	            Matcher matcher = pattern.matcher(inputReq);

	            // Vérifie si la chaîne reçue correspond au modèle d'expression régulière
	            if (matcher.matches()) {
	                int id = Integer.parseInt(matcher.group(2).trim());
	                int valeur = Integer.parseInt(matcher.group(1).trim());
	                String date = matcher.group(3).trim();

					
					  Capteur capteur = new Capteur(id, valeur, date);
					  
					  this.setCapteur(capteur);
					  
					  this.sauvegarde(capteur);
					
					  
					  capteur.toString();
										
						/*
						 * CapteurDmpl capteurdao = new CapteurDmpl();
						 * 
						 * Capteur savedCapteur = capteurdao.save(capteur);
						 */
					 

	                System.out.println("Capteur sauvegardé (id, valeur bruit, date) : " + id +","+ valeur +","+ date);
	            } else {
	                System.out.println("Format de données incorrect");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Pb d'exceptionn:  "+ e.getMessage());
	    }
	}
	
	
	public void sauvegarde(Capteur capteur) {
		CapteurDmpl capteurdao = new CapteurDmpl();
		try {
			capteurdao.save(capteur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	
	}
}
