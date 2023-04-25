package dao.intervenant;


import dao.Dao;
import entities.Intervenant;
import entities.Responsable;
import entities.Task;

import java.util.List;

public interface IntervenantDAO extends Dao<Intervenant> {
    List<Intervenant> getIntervenantsByTask(Task t);
}
