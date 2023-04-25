package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projet implements Serializable {
    private long ID=0;
    private String TITLE="";
    private Date date=new Date();
    private List<Task> TASKS=new ArrayList<>();
    private Responsable RESPONSABLE=new Responsable();
    private String priorite;


    public Projet() {}

    public Projet(long ID, String TITLE, Date date,Responsable RESPONSABLE) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.date = date;
        this.RESPONSABLE=RESPONSABLE;
        this.priorite = "high";
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Task> getTASKS() {
        return TASKS;
    }

    public void setTASKS(List<Task> TASKS) {
        this.TASKS = TASKS;
    }

    public Responsable getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setRESPONSABLE(Responsable RESPONSABLE) {
        this.RESPONSABLE = RESPONSABLE;
    }

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
    
}
