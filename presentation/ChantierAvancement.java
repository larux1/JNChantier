package presentation;

import java.util.Date;
import java.util.List;

import entities.Capteur;
import entities.Task;

public class ChantierAvancement {
    
    public static double calculerAvancement(List<Capteur> capteurs, Task task) {
        
        Date dateDebut = task.getDATE_DEBUT();
        Date dateFin = task.getDATE_FIN();
        long dureeTotale = dateFin.getTime() - dateDebut.getTime();
        
        if (dureeTotale <= 0) {
            return 0;
        }

        long currentTime = new Date().getTime();
        long dureeEcoulee = currentTime - dateDebut.getTime();

        double avancementTheorique = (double) dureeEcoulee / dureeTotale;
        
        double avancementCapteurs = 0;
        int nombreCapteurs = capteurs.size();

        for (Capteur capteur : capteurs) {
            avancementCapteurs += (double) capteur.getValeur() / 100;
        }

        if (nombreCapteurs > 0) {
            avancementCapteurs /= nombreCapteurs;
        }

        double avancementFinal = Math.min(avancementTheorique, avancementCapteurs);
        return avancementFinal;
    }

}
