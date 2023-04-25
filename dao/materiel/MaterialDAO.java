package dao.materiel;

import dao.Dao;
import entities.*;

import java.util.List;

public interface MaterialDAO extends Dao<Materiel> {
    public List<Materiel> getMaterielsByResponsable(Responsable r);
    public List<Materiel> getMaterielsByTask(Task t);
}
