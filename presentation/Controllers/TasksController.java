package presentation.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import entities.Projet;
import entities.Task;
import services.task.task;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TasksController implements Initializable {

    task taskImpl = new task();

    @FXML
    private TableView table = new TableView();

    @FXML
    private TableColumn title;
    @FXML
    private TableColumn descr;
    @FXML
    private TableColumn dateDebut;
    @FXML
    private TableColumn dateFin;
    @FXML
    private TableColumn projet;


    @FXML
    private Button ajouterTask;
    @FXML
    private Button home;

    private ObservableList<Task> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        descr.setCellValueFactory(
                new PropertyValueFactory<Task,String>("DESCRIPTION")
        );
        title.setCellValueFactory(
                new PropertyValueFactory<Task,String>("TITLE")
        );
        dateDebut.setCellValueFactory(
                new PropertyValueFactory<Task,String>("DATE_DEBUT")
        );

        dateFin.setCellValueFactory(
                new PropertyValueFactory<Task,String>("DATE_FIN")
        );

        projet.setCellValueFactory(
                new PropertyValueFactory<Task,String>("TITLE")
        );

        try {
            List<Task> tsks = taskImpl.retournerTasks();
            System.out.println(tsks.size());
            for (Task tsk:tsks) {
                observableList.add(tsk)  ;
            }
            table.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    @FXML
    public void getAjouterTaskScene() throws IOException {
    	URL url = new File("C:\\Users\\admin\\eclipse-workspace\\JNChantier\\src\\presentation\\Views\\ajouterTache.fxml").toURI().toURL();
    	if (url == null) {
    	    throw new RuntimeException("Cannot find dashboard.fxml");
    	}
    	Parent root = FXMLLoader.load(url);
    	
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/profile.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("Ajoute Tâche");
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
