package dao.projet;

import dao.Dao;
import entities.Projet;
import entities.Responsable;
import entities.Task;

import java.util.List;

public interface ProjetDAO extends Dao<Projet> {
    public List<Projet> getProjetsByResponsable(Responsable r);
    public Projet getProjetByTask(Task t);
}
