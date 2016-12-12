package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.geometry.Pos;
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
			felicitacion.setAlignment(Pos.CENTER);
			felicitacion.setPrefSize(500, 200);
			felicitacion.setStyle("-fx-text-fill:#ffcc00; -fx-font-size: 24");
			
		Label mensaje = new Label (Juego.instancia().obtenerJugadorActivo().nombre() + " ha ganado la batalla!");
			mensaje.setAlignment(Pos.CENTER);
			mensaje.setPrefSize(500, 300);
			mensaje.setStyle("-fx-text-fill:#ffcc00; -fx-font-size:20");
			
		VBox vb = new VBox();
			vb.setPrefSize(500, 500);
			vb.setStyle("-fx-background-color: #336699");
			vb.getChildren().addAll(felicitacion,mensaje);
		
		pantalla.setCenter(vb);
		
	}

}
