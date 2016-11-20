package fiuba.algo3.algomon.vista;

import java.awt.TextField;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Ejecutar extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      stage.setScene(new EscenaPrincipal(stage));
      stage.setTitle("Algomon 2.0 BETA Version");
      stage.show();

    }

    
}
