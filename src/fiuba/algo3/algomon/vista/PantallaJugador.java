package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.control.JugadoresControlador;
import fiuba.algo3.algomon.excepciones.IngresarDosJugadoresException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaJugador extends Scene {

    private Ejecutar aplicacion;
    static BorderPane rootPane = new BorderPane();
    static FlowPane pantalla = new FlowPane();
    public TextField txtNombreJugador1,txtNombreJugador2;

    public PantallaJugador(Stage ventana, Ejecutar aplicacion) {
        super(rootPane,500,600);
        this.aplicacion = aplicacion;
        
        rootPane.setTop(aplicacion.barraDeMenu());
        rootPane.setCenter(pantalla);
        
        mostrarPantallaJugadores();
    }

    private void mostrarPantallaJugadores() {

        VBox vboxJugador1 = new VBox();
            Label lblNombreJugador1 = new Label("Nombre de entrenador/a Algomon N1: ");
            lblNombreJugador1.setStyle("-fx-text-fill: #ffffff; -fx-padding:20 44; -fx-font-size: 20;");
            txtNombreJugador1 = new TextField();
            txtNombreJugador1.setStyle("-fx-padding:20 24; -fx-font-size: 20;");
        vboxJugador1.setPrefSize(500, 200);
        vboxJugador1.getChildren().addAll(lblNombreJugador1, txtNombreJugador1);

        VBox vboxJugador2 = new VBox();
            Label lblNombreJugador2 = new Label("Nombre de entrenador/a Algomon N2: ");
            lblNombreJugador2.setStyle("-fx-text-fill: #ffffff;-fx-padding:20 44; -fx-font-size: 20;");
            txtNombreJugador2 = new TextField();
            txtNombreJugador2.setStyle("-fx-padding:20 24; -fx-font-size: 20;");
        vboxJugador2.setPrefSize(500, 200);
        vboxJugador2.getChildren().addAll(lblNombreJugador2, txtNombreJugador2);

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setOnAction(e -> {
            JugadoresControlador c = new JugadoresControlador(this, aplicacion);
            try {
				c.agregarJugadores();
				aplicacion.crearPantallaEleccionAlgomones();
			} catch (IngresarDosJugadoresException e1) {
				Label errorJugadores = new Label("Se deben ingresar los nombres de\n los dos entrenadores!");
				errorJugadores.setStyle("-fx-font-size: 20; -fx-padding: 34 60 ; -fx-text-alignment: center; -fx-text-fill: #ff9966"); 
				pantalla.getChildren().add(errorJugadores);
			}
        });
        btnContinuar.setStyle(	"-fx-background-radius: 30; -fx-padding: 20; -fx-background-color: #ffcc00;"
        		+ "-fx-font-size:24; -fx-font-weight:bold; -fx-text-fill:#336699;");
        
        pantalla.getChildren().addAll(vboxJugador1,vboxJugador2,btnContinuar);
        pantalla.setStyle("-fx-background-color: #336699;");
    }

}
