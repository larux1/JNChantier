package services.responsable;

import entities.Materiel;
import entities.Projet;
import entities.Responsable;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public interface responsableService extends Service<Projet> {
    public List<Responsable> retournerResponsables() throws SQLException;
    public Responsable retournerResponsableParId(long id) throws SQLException;
    public Responsable retournerResponsableParMateriel(Materiel m) throws SQLException;
    public Responsable retournerResponsableParProjet(Projet p) throws SQLException;
    public void ajouterResponsable(Responsable r) throws SQLException;

    public void supprimerResponsable(Responsable r) throws SQLException;

    public void modifierResponsable(Responsable r) throws SQLException;
    public void enregistrerResponsable(Responsable r) throws SQLException;
}
