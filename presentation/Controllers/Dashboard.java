package presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.ExportData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private Button getCharts;

    @FXML
    private Button getIntervenant;

    @FXML
    private Button getProjects;

    @FXML
    private Button getTasks;

    @FXML
    private Button getprofile;

    @FXML
    private Button home;

    @FXML
    private Button importExport;

    @FXML
    private Button logout;

    @FXML
    private Button tacheAffectation;

    @FXML
    private Button tasks;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    @FXML
    public void getProjectsScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\projects.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Projets");
        window.setScene(new Scene(root , 600, 400));
    }
    
    @FXML
    public void getInterenantsList() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\Intervanats.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Intervenant");
        window.setScene(new Scene(root , 600, 400));
    }
    @FXML
    public void getTasksList() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\Tasks.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Tâches");
        window.setScene(new Scene(root , 600, 400));
    }
    @FXML
    public void logSceneOut() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\login.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("login");
        window.setScene(new Scene(root , 600, 400));
    }
    
    @FXML
    public void getProfileScene() throws IOException {
    	
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\bpmn.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Profile");
        window.setScene(new Scene(root , 800, 600));
    }
    
    @FXML
    public void getHomeScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\dashboard.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Dashboard");
        window.setScene(new Scene(root , 600, 400));
    }
    
    @FXML
    public void getTacheAffectationScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\affectation.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Affectation");
        window.setScene(new Scene(root , 600, 400));
    }
    
    @FXML
    public void exportData() throws SQLException, FileNotFoundException {
        ExportData exportData = new ExportData();
        exportData.exportData("project_data.csv");
        System.out.println("Clicked");
    }

}
