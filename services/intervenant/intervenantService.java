package services.intervenant;

import entities.Intervenant;
import entities.Task;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public interface intervenantService extends Service<Intervenant> {
    List<Intervenant> retournerIntervenants() throws SQLException;
    Intervenant retournerIntervenantParId(Intervenant i) throws SQLException;
    List<Intervenant> retournerIntervenantsParTask(Task t) throws SQLException;
    void ajouterIntervenant(Intervenant i) throws SQLException;

    void supprimerIntervenant(Intervenant i) throws SQLException;

    void modifierIntervenant(Intervenant i) throws SQLException;
    void enregistrerIntervenant(Intervenant i) throws SQLException;

    Intervenant findByEmailAndPassword(String email, String password);

}
