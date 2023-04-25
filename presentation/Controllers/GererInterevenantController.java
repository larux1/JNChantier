package presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entities.Intervenant;
import services.intervenant.intervenant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GererInterevenantController implements Initializable {
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
    private TableColumn nom;
    @FXML
    private TableColumn prenom;
    @FXML
    private TableColumn cin;

    @FXML
    private TableColumn phone;

    @FXML
    private Button home;

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
    public void ajouterIntervenantHandler() throws SQLException {
        String first_name = FirstNom.getText();
        String last_name = lastNom.getText();
        String user_email = email.getText();
        String user_CIN = CIN.getText();
        String user_tel = Tel.getText();
        interImpl.ajouterIntervenant(new Intervenant(1 , first_name , last_name , user_CIN, user_tel, user_email , "1234"));
    }
}
