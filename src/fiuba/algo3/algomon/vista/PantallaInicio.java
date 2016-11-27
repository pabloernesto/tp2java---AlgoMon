package fiuba.algo3.algomon.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PantallaInicio extends Scene {

	private Stage ventana;
	static BorderPane rootPane = new BorderPane();
	
	public PantallaInicio(Stage aplicacion) {
		super(rootPane, 480, 480);
		this.ventana = aplicacion;
		
		mostrarPantallaInicio();
	}

	private void mostrarPantallaInicio() {		
        Image imgLogo = new Image("images/pokemon-logo.png");
        Button btnStart = new Button();
        btnStart.setGraphic(new ImageView(imgLogo));
        btnStart.setStyle("-fx-background-color: #336699;");
        btnStart.setOnAction(e-> {
               ventana.setScene(new CrearJugador(ventana));
        });;
        rootPane.setCenter(btnStart);
	
		rootPane.setStyle("-fx-background-color: #336699;");
	}

}
