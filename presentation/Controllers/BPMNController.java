package presentation.Controllers;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import dao.capteur.CapteurDmpl;
import dao.task.TaskDmpl;
import entities.Capteur;
import entities.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.ChantierAvancement;
import presentation.CollecteDonnees;

public class BPMNController {
	

    @FXML
    private Label tacheLab;

	@FXML
	private Button generebpmn;
	
	
    @FXML
    private Button graphButton;

    @FXML
    private AnchorPane graphContainer;

    @FXML
    private Button home;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    @FXML
    private Button refreshButton;


    private CollecteDonnees collecteDonnees;
    List<Capteur> listcapteur;
    

    public List<Capteur> getListcapteur() {
		return listcapteur;
	}

	public void setListcapteur(List<Capteur> listcapteur) {
		this.listcapteur = listcapteur;
	}

	public void initialize() throws InterruptedException {
		
		tacheLab.setTextFill(javafx.scene.paint.Color.rgb(0, 0, 0, 0)); 
		
		
    	collecteDonnees = new CollecteDonnees();
    	
    	CapteurDmpl cp= new CapteurDmpl(); 
    	try {
			this.setListcapteur(cp.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        refreshButton.setOnAction(event -> {
			try {
				refreshAction();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        generebpmn.setOnAction(event -> {
			try {
				generebpmnAction();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
        graphButton.setOnAction(event -> {
			try {
				displayGraph();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }

    void demarrerServeur() throws InterruptedException {
        collecteDonnees.execution();
        
		/*
		 * for(int i=1;i<200;i++) { listcapteur.add(collecteDonnees.getC());
		 * Thread.sleep(3000); }
		 */
    }
    
    @FXML
    private void refreshAction() throws InterruptedException, SQLException {
    	
    	tacheLab.setTextFill(javafx.scene.paint.Color.BLACK);
    	
        // Démarrer le serveur et collecter les données des capteurs
    	//this.demarrerServeur();
    	
        
        // Mettre à jour l'état d'avancement de la tâche avec les nouvelles données des capteurs
        TaskDmpl task =  new TaskDmpl();
        
        double progress = ChantierAvancement.calculerAvancement(this.listcapteur,task.findOne(1));
        progressLabel.setText(String.format("%.0f%%", progress * 100));
        progressBar.setProgress(progress);
    }

    @FXML
    private void displayGraph() throws InterruptedException {
    	
        Thread.sleep(2000);
        // Créer les axes du graphe
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Temps");
        yAxis.setLabel("Valeur");

        // Créer le graphe
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Graphe des capteurs");

        // Créer la série de données
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Capteurs");

        // Ajouter les données des capteurs à la série
        
        for (int i = 0; i < this.listcapteur.size(); i++) {
            Capteur capteur = this.listcapteur.get(i);
            series.getData().add(new XYChart.Data<>(i, capteur.getValeur()));
        }

        // Ajouter la série au graphe
        lineChart.getData().add(series);

        // Ajouter le graphe au conteneur "conteneurdegraphe"
        graphContainer.getChildren().add(lineChart);
    }
    
    
    @FXML
    void generebpmnAction() throws InterruptedException {
    	this.demarrerServeur();
    	
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
