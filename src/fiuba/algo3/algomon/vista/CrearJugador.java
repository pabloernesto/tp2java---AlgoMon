package fiuba.algo3.algomon.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CrearJugador extends Scene {
	
	static BorderPane rootPane = new BorderPane();
	//private Stage stage;

	public CrearJugador() {
	    
		super(rootPane,480,480);
	    //this.stage = stage;
	
	    Label lblNombreJugador = new Label("Nombre de entrenador/a Algomon N1: ");
	    rootPane.setTop(lblNombreJugador);
	    lblNombreJugador.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-padding-top: 4em"); 
	    BorderPane.setAlignment(lblNombreJugador, Pos.CENTER);
	
	    TextField txtNombreJugador = new TextField();
	    rootPane.setCenter(txtNombreJugador);
	    BorderPane.setAlignment(txtNombreJugador, Pos.CENTER);
	    
	    Button btnContinuar = new Button("Continuar");
	    btnContinuar.setOnAction(e-> {
	    	// TODO Conectar con modelo a traves del control - Update de Jugador
	    	lblNombreJugador.setText("Nombre de entrenador/a Algomon N2: ");
	    	txtNombreJugador.clear();
	    });
	    rootPane.setBottom(btnContinuar);
	    BorderPane.setAlignment(btnContinuar, Pos.CENTER);
	}

}
