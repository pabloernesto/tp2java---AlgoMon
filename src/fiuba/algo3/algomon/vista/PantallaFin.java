package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PantallaFin extends Scene {

	private static BorderPane rootPane = new BorderPane();
	private static BorderPane pantalla = new BorderPane();
	
	public PantallaFin(Ejecutar aplicacion) {
		super(rootPane,500,600);
		
		rootPane.setTop(aplicacion.barraDeMenu());
        rootPane.setCenter(pantalla);
        
        mostrarPantallaGanador();
	}

	private void mostrarPantallaGanador() {
		Label felicitacion = new Label("FELICITACIONES");
		felicitacion.setStyle("-fx-text-fill:#ffcc00; -fx-font-size: 24");
		Label mensaje = new Label (Juego.instancia().obtenerJugadorActivo() + " ha ganado la batalla!");
		mensaje.setStyle("-fx-text-fill:#ffcc00; -fx-font-size:20");
		
		VBox vb = new VBox();
		vb.setStyle("-fx-background-color: #336699");
		vb.getChildren().addAll(felicitacion,mensaje);
		vb.setPrefSize(400, 200);
		
		pantalla.setCenter(vb);
		
	}

}
