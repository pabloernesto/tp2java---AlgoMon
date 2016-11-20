package fiuba.algo3.algomon.vista;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejecutar extends Application {

    private Stage stage;
    private BorderPane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() throws IOException {

        rootPane = new BorderPane();

        Scene escena = new Scene(rootPane,300,275,Color.BLUE);
        stage.setTitle("Algomong 1.0 BETA Version");
        stage.setScene(escena);

        stage.show();
    }
}
