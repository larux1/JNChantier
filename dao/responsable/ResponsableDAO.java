package dao.responsable;

import dao.Dao;
import entities.Materiel;
import entities.Projet;
import entities.Responsable;

import java.util.List;

public interface ResponsableDAO extends Dao<Responsable> {
    Responsable getResponsablesByMateriel(Materiel m);
    Responsable getResponsablesByProjet(Projet p);
}
