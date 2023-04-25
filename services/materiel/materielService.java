package services.materiel;

import entities.Materiel;
import entities.Responsable;
import entities.Task;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public interface materielService extends Service<Materiel> {
    public List<Materiel> retournerMateriels() throws SQLException;
    public Materiel retournerMaterielParId(Materiel m) throws SQLException;
    public List<Materiel> retournerMaterielsParTask(Task t) throws SQLException;
    public List<Materiel> retournerMaterielsParResponsable(Responsable r) throws SQLException;
    public void ajouterMateriel(Materiel m) throws SQLException;

    public void supprimerMateriel(Materiel m) throws SQLException;

    public void modifierMateriel(Materiel m) throws SQLException;
    public void enregistrerMateriel(Materiel m) throws SQLException;

}
