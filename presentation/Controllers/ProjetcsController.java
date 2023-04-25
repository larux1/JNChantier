package presentation.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import entities.Projet;
import services.projet.projet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ProjetcsController implements Initializable {

    projet projetImpl = new projet();

    @FXML
    private Button ajouterPrpoject;

    @FXML
    private Button home;

    @FXML
    private ChoiceBox<String> choiPriorité;

    @FXML
    private ChoiceBox<String> choiResponsable;

    @FXML
    private TableView table = new TableView();

    @FXML
    private TableColumn c1;
    @FXML
    private TableColumn title;
    @FXML
    private TableColumn dates;
    @FXML
    private TableColumn progression;




    private String[] prioritéChoix = {"low" , "high"};
    private ObservableList<Projet> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setCellValueFactory(
                new PropertyValueFactory<Projet,String>("ID")
        );
        title.setCellValueFactory(
                new PropertyValueFactory<Projet,String>("TITLE")
        );
        dates.setCellValueFactory(
                new PropertyValueFactory<Projet,String>("date")
        );

        progression.setCellValueFactory(
                new PropertyValueFactory<String,String>("date")
        );

        try {
            List<Projet> projets = projetImpl.retournerProjets();
            for (Projet prjt:projets) {
                observableList.add(new Projet(prjt.getID() , prjt.getTITLE() , prjt.getDate() , prjt.getRESPONSABLE()))  ;
            }
            table.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    public void getAjouterProjectScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\ajouter_projet.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Projets");
        window.setScene(new Scene(root , 600, 400));

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
