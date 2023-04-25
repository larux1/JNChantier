package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entities.Capteur;

public class AnalyseBruit {
    private final double seuilMinimal;
    private final double seuilMaximal;
    private final Map<Long, Double> sommeNiveauxBruit;

    public AnalyseBruit(double seuilMinimal, double seuilMaximal) {
        this.seuilMinimal = seuilMinimal;
        this.seuilMaximal = seuilMaximal;
        this.sommeNiveauxBruit = new HashMap<>();
    }

    public boolean travailEnCours(Capteur capteur) {
        long idCapteur = capteur.getId();
        double valeur = capteur.getValeur();
        double somme = sommeNiveauxBruit.getOrDefault(idCapteur, 0.0);

        somme += valeur;
        sommeNiveauxBruit.put(idCapteur, somme);

        return somme >= seuilMinimal && somme <= seuilMaximal;
    }

    public String etatChantier(List<Capteur> capteurs) {
        for (Capteur capteur : capteurs) {
            travailEnCours(capteur);
        }

        StringBuilder etatChantier = new StringBuilder();
        for (Map.Entry<Long, Double> entry : sommeNiveauxBruit.entrySet()) {
            etatChantier.append("Capteur ")
                    .append(entry.getKey())
                    .append(" : avancement ")
                    .append(entry.getValue() >= seuilMaximal ? "complet" : "en cours")
                    .append("\n");
        }

        return etatChantier.toString();
    }
}

