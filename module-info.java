module JNChantier {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;

	requires javafx.fxml;
	requires mysql.connector.java;
	
	exports Controller;
	
	opens Controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	opens presentation.Controllers to javafx.graphics, javafx.fxml;
	opens presentation to javafx.graphics, javafx.fxml;

	opens dao to javafx.graphics, javafx.fxml;
	opens services to javafx.graphics, javafx.fxml;
	opens entities to javafx.graphics, javafx.fxml, javafx.base;
}
