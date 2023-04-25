package presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import entities.Intervenant;
import entities.Materiel;
import services.intervenant.intervenant;
import services.materiel.materiel;
import services.notification.notification;
import services.order_de_travail.order_de_travail;
import services.projet.projet;
import services.responsable.responsable;
import services.task.task;

import java.sql.SQLException;

public class ApplicationJavaFx extends Application{

	public static Stage stg;

       public static void main(String[] args) {
         launch(args);
        }


@Override
/*
 * public void start(Stage primaryStage) throws Exception { AnchorPane root =
 * FXMLLoader.load(getClass().getResource("Views/login.fxml")); Scene scene =
 * new Scene(root, 600 , 400); // get CSS // scene.getStyles
 * heets().add(getClass().getResource("css/style.css").toExternalForm());
 * primaryStage.setTitle("Login"); primaryStage.setScene(scene);
 * primaryStage.show(); }
 */

public void start(Stage primaryStage) {
	
	try {
		stg= primaryStage;
		Parent root=FXMLLoader.load(getClass().getResource("Views/login.fxml"));
		Scene scene = new Scene(root);
		stg.setScene(scene);
		stg.show();
	
	} catch(Exception e) {
		e.printStackTrace();
	}
}
}