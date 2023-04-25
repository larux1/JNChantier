package presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import entities.Task;
import services.task.task;

public class GererTasksController implements Initializable {
    task taskIlmpl = new task();
    @FXML
    private Button home;
    @FXML
    private DatePicker dateDebut;

    @FXML
    private DatePicker dateLivraison;

    @FXML
    private TextField tache;
    @FXML
    private TextArea descr;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    
    @FXML
    public void getHomeScene() throws IOException {
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
    
    @FXML
    public void ajouterUneTache() throws SQLException {
        String tacheTitle = tache.getText();
        Date date_debut = java.sql.Date.valueOf(dateDebut.getValue());
        Date date_dateFin = java.sql.Date.valueOf(dateLivraison.getValue());
        String descritption = descr.getText();
        taskIlmpl.ajouterTask(new Task(1 , descritption , date_debut , date_dateFin , tacheTitle));
    }
}
