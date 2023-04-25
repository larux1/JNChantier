package presentation.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import entities.Intervenant;
import entities.Projet;
import entities.User;
import services.intervenant.intervenant;
public class IntervenantController implements Initializable {

    intervenant interImpl = new intervenant();

    @FXML
    private TextField CIN;

    @FXML
    private TextField FirstNom;

    @FXML
    private TextField Tel;

    @FXML
    private TextField email;
    @FXML
    private TextField lastNom;
    @FXML
    private Button ajouterIntervenant;

    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn prenom;
    @FXML
    private TableColumn cin;

    @FXML
    private TableColumn phone;

    @FXML
    private TableColumn actions;

    @FXML
    private TableView table = new TableView();

    @FXML
    private Button home;

    private ObservableList<User> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nom.setCellValueFactory(
                new PropertyValueFactory<User,String>("NOM")
        );
        prenom.setCellValueFactory(
                new PropertyValueFactory<User,String>("PRENOM")
        );
        cin.setCellValueFactory(
                new PropertyValueFactory<User,String>("CIN")
        );

        phone.setCellValueFactory(
                new PropertyValueFactory<User,String>("TEL")
        );

        actions.setCellValueFactory(
                new PropertyValueFactory<String,String>("NOM")
        );

        try {
            List<Intervenant> intervenants = interImpl.retournerIntervenants();
            for (Intervenant inter:intervenants) {
                observableList.add(inter)  ;
            }
            table.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    @FXML
    public void getAjouterIntervenantScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\ajouterIntervenat.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Ajouter Intervenant");
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
