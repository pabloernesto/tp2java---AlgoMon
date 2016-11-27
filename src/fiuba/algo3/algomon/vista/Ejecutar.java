package fiuba.algo3.algomon.vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class Ejecutar extends Application {

    @Override
    public void start (Stage stage) {
    	stage.setScene (new PantallaInicio(stage));
    	stage.setTitle ("Algomon 2.0 BETA Version");
    	stage.setResizable(false);
    	
//    	MenuBar mnubBarra = new MenuBar();
//		mnubBarra.setStyle("-fx-background-color: #FFFFFF;");
//		rootPane.getChildren().add(mnubBarra);
//		
//		MenuItem mnuiSalir = new MenuItem();
//		mnuiSalir.setText("Salir");
    	
    	stage.show ();  
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
