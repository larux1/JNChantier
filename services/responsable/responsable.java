package services.responsable;

import dao.responsable.ResponsableDmpl;
import entities.Materiel;
import entities.Projet;
import entities.Responsable;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public class responsable implements responsableService {
    ResponsableDmpl rdmpl=new ResponsableDmpl();


    @Override
    public List<Responsable> retournerResponsables() throws SQLException {
        return rdmpl.findAll();
    }

    @Override
    public Responsable retournerResponsableParId(long id) throws SQLException {
        return rdmpl.findOne(id);
    }

    @Override
    public Responsable retournerResponsableParMateriel(Materiel m) throws SQLException {
        return rdmpl.getResponsablesByMateriel(m);
    }

    @Override
    public Responsable retournerResponsableParProjet(Projet p) throws SQLException {
        return rdmpl.getResponsablesByProjet(p);
    }

    @Override
    public void ajouterResponsable(Responsable r) throws SQLException {
        rdmpl.save(r);
    }

    @Override
    public void supprimerResponsable(Responsable r) throws SQLException {
        rdmpl.delete(r);
    }

    @Override
    public void modifierResponsable(Responsable r) throws SQLException {
        rdmpl.update(r);
    }

    @Override
    public void enregistrerResponsable(Responsable r) throws SQLException {
        rdmpl.save(r);
    }
}
