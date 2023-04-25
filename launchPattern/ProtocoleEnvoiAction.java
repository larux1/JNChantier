package launchPattern;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import servPattern.IContext;
import servPattern.IProtocole;
import java.awt.AWTException;
import java.awt.Robot;//classe permettant l'émulation de l'appui d'une touche sur le PC du serveur. 

public class ProtocoleEnvoiAction implements IProtocole {
	public void pression(Robot robot, int keycode) {
		
		robot.keyPress(keycode);
		long a=0;
		for (long i=1;i<=500000;i++) {
			for (long j=1;j<=500000;j++) {
				for (long k=1;k<=500000;k++) {
					a=a+i^2+j^2+k^2;
				}
			}
			a=a+i^2;
		}
	}
	public void execute( IContext c , InputStream unInput , OutputStream unOutput ) throws AWTException {
		
		int boucle=500;
		while (boucle>1) {
			Robot robot=new Robot();
			String inputReq;
			BufferedReader is = new BufferedReader(new InputStreamReader(
					unInput));
			PrintStream os = new PrintStream(unOutput);
			try {
				String valeurExpediee = "";

				if ((inputReq = is.readLine()) != null) {
					System.out.println(" Ordre Recu " + inputReq);
					String chaines[] = inputReq.split(" ");

					if (chaines[0].contentEquals("RIGHT")) {
						robot.keyPress(68);
						valeurExpediee = "RIGHT";
						System.out.println(" Reponse serveur "	+ valeurExpediee);
					}
					if (chaines[0].contentEquals("LEFT")) {
						robot.keyPress(81);
						valeurExpediee = "LEFT";
						System.out.println(" Reponse serveur "	+ valeurExpediee);
					}
					if (chaines[0].contentEquals("UP")) {
						robot.keyPress(90);
						valeurExpediee = "UP";
						System.out.println(" Reponse serveur "	+ valeurExpediee);
					}
					
					if (chaines[0].contentEquals("LEFTRELEASED")) {
						robot.keyRelease(81);
						valeurExpediee = "LEFTRELEASED";
						System.out.println(" Reponse serveur "	+ valeurExpediee);
					}
					if (chaines[0].contentEquals("RIGHTRELEASED")) {
						robot.keyRelease(68);
						valeurExpediee = "RIGHTRELEASED";
						System.out.println(" Reponse serveur "	+ valeurExpediee);
					}
					os.println(valeurExpediee);
				}
			} catch ( Exception e) {
				System.out.println(" Pb d'exception ");
			}	
			boucle--;
		}
		}
}