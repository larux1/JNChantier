package presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import netscape.security.UserTarget;
import entities.Intervenant;
import services.intervenant.intervenant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField emailLogin;

    @FXML
    private Button loginButton;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField passwordLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loginButtonFunc() throws IOException {
        intervenant intervenant = new intervenant();
        String email = emailLogin.getText();
        String password = passwordLogin.getText();
       // intervenant.findByEmailAndPassword();

        Intervenant intervenant1 = intervenant.findByEmailAndPassword(email , password);

        if (intervenant1.getNOM() == "") {
            System.out.println("Nom : " + intervenant1.getNOM());
            errorMessage.setText("Erreur de connexion, veillez réessayer");
        } else {
            System.out.println("Nom : " + intervenant1.getNOM());
            URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\dashboard.fxml").toURI().toURL();
        	if (url == null) {
        	    throw new RuntimeException("Cannot find dashboard.fxml");
        	}
        	Parent root = FXMLLoader.load(url);
            
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setTitle("Dashboard");
            window.setScene(new Scene(root , 600, 400));
        }


    }

    public void forgetPassword() {

    }

}
