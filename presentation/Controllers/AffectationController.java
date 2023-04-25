package presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import entities.Intervenant;
import entities.Materiel;
import entities.Task;
import services.task.task;
import services.intervenant.intervenant;
import services.materiel.materiel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AffectationController implements Initializable {
    task tskImpl = new task();
    intervenant intervImpl = new intervenant();
    materiel materImpl = new materiel();
    @FXML
    private ChoiceBox tache;

    @FXML
    private Button home;
    @FXML
    private ChoiceBox materiel;
    @FXML
    private ChoiceBox intervanant;
    @FXML
    private ChoiceBox tache_2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            List<Task> tasks = tskImpl.retournerTasks();
            for (Task tsk: tasks) {
                tache.getItems().add(tsk.getTITLE() + " : " + tsk.getID());
                tache_2.getItems().add(tsk.getTITLE() + " : " + tsk.getID());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            List<Intervenant> intervenants = intervImpl.retournerIntervenants();
            for (Intervenant intervs: intervenants) {
                intervanant.getItems().add(intervs.getNOM() + " : " + intervs.getID());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Materiel> materiels = materImpl.retournerMateriels();
            for (Materiel mtriel: materiels) {
                materiel.getItems().add(mtriel.getNOM() + " : " + mtriel.getID());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void affecteurMateriel() {
        String material = (String) materiel.getValue();
        String taskChoi = (String) tache.getValue();
        long matId = Integer.parseInt(material.split(" : ")[1]);
        long taskInt = Integer.parseInt(taskChoi.split(" : ")[1]);

        tskImpl.affecter_materiel(taskInt , matId);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("vous avez affectuer un materiel à une tache");
        alert.show();
    }
    // Les niveaux de bruits ont leur impact 
    
    @FXML
    public void affecteurInterevanant(){
        String interChoi = (String) intervanant.getValue();
        String taskChoi = (String) tache_2.getValue();
        long interId = Integer.parseInt(interChoi.split(" : ")[1]);
        long taskInt = Integer.parseInt(taskChoi.split(" : ")[1]);

        tskImpl.affecter_intervenant(taskInt , interId);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("vous avez affectuer un intevanant à une tache");
        alert.show();
    }
    
    @FXML
    public void goHome() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\dashboard.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Dashboard");
        window.setScene(new Scene(root , 600, 400));
    }


}
