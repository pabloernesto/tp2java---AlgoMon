package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PantallaInicio extends Scene {

	private Ejecutar aplicacion;
	static BorderPane rootPane = new BorderPane();
	
	public PantallaInicio(Stage ventana, Ejecutar aplicacion) {
		super(rootPane, 500, 600);
		this.aplicacion = aplicacion;
		
		mostrarPantallaInicio();
	}

	private void mostrarPantallaInicio() {		
        Image imgLogo = new Image("images/pokemon-logo.png");
        Button btnStart = new Button();
        btnStart.setGraphic(new ImageView(imgLogo));
        btnStart.setStyle("-fx-background-color: #336699;");
        btnStart.setOnAction(e-> {
        	aplicacion.crearPantallaJugadores();
        });;
        rootPane.setCenter(btnStart);
	
		rootPane.setStyle("-fx-background-color: #336699;");
	}

}
