package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.JugadoresControlador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaJugador extends Scene {

	private Ejecutar aplicacion;
	static FlowPane rootPane = new FlowPane();
	public TextField txtNombreJugador1,txtNombreJugador2;
	
	public PantallaJugador(Stage ventana, Ejecutar aplicacion) {
        super(rootPane,480,480);
        this.aplicacion = aplicacion;

        mostrarPantallaJugadores();
    }

	private void mostrarPantallaJugadores() {
		
		HBox hboxJugador1 = new HBox();
			Label lblNombreJugador1 = new Label("Nombre de entrenador/a Algomon N°1: ");
	        txtNombreJugador1 = new TextField();
        hboxJugador1.getChildren().addAll(lblNombreJugador1, txtNombreJugador1);
        
		HBox hboxJugador2 = new HBox();
			Label lblNombreJugador2 = new Label("Nombre de entrenador/a Algomon N°2: ");
	        txtNombreJugador2 = new TextField();
        hboxJugador2.getChildren().addAll(lblNombreJugador2, txtNombreJugador2);

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setOnAction(e -> {
        	new JugadoresControlador(this, aplicacion);
        	aplicacion.crearPantallaEleccionAlgomones();
        });
        
        rootPane.getChildren().addAll(hboxJugador1,hboxJugador2,btnContinuar);
	}

}
