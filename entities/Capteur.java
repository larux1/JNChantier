package entities;

import java.io.Serializable;

public class Capteur implements Serializable {
    private int id;
    private int valeur;
    private String date;

    public Capteur() {}

    public Capteur(int id, int valeur, String date) {
        this.id = id;
        this.valeur = valeur;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

	@Override
	public String toString() {
		return "Capteur [id=" + id + ", valeur=" + valeur + ", date=" + date + "]";
	}
    
    
}
