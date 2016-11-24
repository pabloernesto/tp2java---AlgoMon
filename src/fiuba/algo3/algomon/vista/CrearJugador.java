package fiuba.algo3.algomon.vista;

import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CrearJugador extends Scene {

    static BorderPane rootPane = new BorderPane();

    public CrearJugador(Stage stage) {

        super(rootPane,480,480);

        Label lblNombreJugador = new Label("Nombre de entrenador/a Algomon N1: ");
        rootPane.setTop(lblNombreJugador);
        lblNombreJugador.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-padding-top: 4em");
        BorderPane.setAlignment(lblNombreJugador, Pos.CENTER);

        TextField txtNombreJugador = new TextField();
        rootPane.setCenter(txtNombreJugador);
        BorderPane.setAlignment(txtNombreJugador, Pos.CENTER);

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setOnAction(e -> {
        	// TODO Depende del jugador que sea se pasa a otra pantalla CrearJugador o a ElegirAlgomones
            stage.setScene(new EscenaBatalla(stage));
        });
        rootPane.setBottom(btnContinuar);
        BorderPane.setAlignment(btnContinuar, Pos.CENTER);
    }

}
