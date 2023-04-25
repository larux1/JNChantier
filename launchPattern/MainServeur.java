package launchPattern;

import entities.Capteur;
import servPattern.ServeurTCP;

public class MainServeur {

	
	public static void main(String[] args) {
	
		ServeurTCP myServ = new ServeurTCP(new UnContexte() , new ProtocolePingPong() , 1238 );
		myServ.start();
		
		Capteur capteur = ((ProtocolePingPong)myServ.getProtocole()).getCapteur();
		/*
		 * CapteurDmpl capteurdao = new CapteurDmpl();
		 * 
		 * Capteur savedCapteur = capteurdao.save(capteur);
		 */
	}
	
	
}