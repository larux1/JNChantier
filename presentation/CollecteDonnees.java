package presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.capteur.CapteurDmpl;
import entities.Capteur;
import launchPattern.ProtocolePingPong;
import launchPattern.UnContexte;
import servPattern.ServeurTCP;

public class CollecteDonnees {
    private List<Capteur> listecapteur;
    private Capteur c;
    
    
    public Capteur getC() {
		return c;
	}


	public void setC(Capteur c) {
		this.c = c;
	}


	public CollecteDonnees() {
        this.listecapteur = new ArrayList<Capteur>();
    }
 
	
	public void execution () throws InterruptedException {
		ServeurTCP myServ = new ServeurTCP(new UnContexte() , new ProtocolePingPong() , 1123 );
		myServ.start();
		
		while(true) {
		Capteur capteur = ((ProtocolePingPong)myServ.getProtocole()).getCapteur();	
		//listecapteur.add(capteur);
		//this.setC(capteur);
		
		/*
		 * this.sauvegarde(capteur); Thread.sleep(2000);
		 */
		
		
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
	
	
    public List<Capteur> getDonnees() {
        return listecapteur;
    }
	
	
}
