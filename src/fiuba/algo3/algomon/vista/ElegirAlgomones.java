package fiuba.algo3.algomon.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ElegirAlgomones extends Scene{

    static BorderPane rootPane = new BorderPane();

    public ElegirAlgomones(Stage stage) {
        super(rootPane,480,480);

        String jugador = null;

        Label lblElegirAlgomones = new Label("Entrenador/a " + jugador + " elija tres algomones");
        Label lblAclaracion = new Label("Tenga en cuenta que el primer algomon elegido sera su primer algomon activo.");
        rootPane.setTop(lblElegirAlgomones);
        rootPane.setTop(lblAclaracion);
        BorderPane.setAlignment(lblElegirAlgomones, Pos.CENTER);
        BorderPane.setAlignment(lblAclaracion, Pos.CENTER);

        // TODO Eleccion de algomones

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setOnAction(e -> {
            // TODO Depende del jugador que sea se pasa a otra pantalla ElegirAlgomones o a EscenaBatalla
            stage.setScene(new EscenaBatalla(stage));
        });
        rootPane.setBottom(btnContinuar);
        BorderPane.setAlignment(btnContinuar, Pos.CENTER);

    }

}
