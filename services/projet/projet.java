package services.projet;

import dao.projet.ProjetDmpl;
import entities.Projet;
import entities.Responsable;
import entities.Task;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public class projet implements projetService {
    ProjetDmpl pdmpl=new ProjetDmpl();

    @Override
    public List<Projet> retournerProjets() throws SQLException {
        return pdmpl.findAll();
    }

    @Override
    public Projet retournerProjetParId(Projet p) throws SQLException {
        return pdmpl.findOne(p.getID());
    }

    @Override
    public List<Projet> retournerProjetsParResponsable(Responsable r) throws SQLException {
        return pdmpl.getProjetsByResponsable(r);
    }

    @Override
    public Projet retournerProjetParTask(Task t) throws SQLException {
        return pdmpl.getProjetByTask(t);
    }

    @Override
    public void ajouterProjet(Projet p) throws SQLException {
        pdmpl.save(p);
    }

    @Override
    public void supprimerProjet(Projet p) throws SQLException {
        pdmpl.delete(p);
    }

    @Override
    public void modifierProjet(Projet p) throws SQLException {
        pdmpl.update(p);
    }

    @Override
    public void enregistrerProjet(Projet p) throws SQLException {
        pdmpl.save(p);
    }
}
