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
  
        Scene escena = new Scene(rootPane,300,275);
        stage.setTitle("Algomon 2.0 BETA Version");
        stage.setScene(escena);
      
        Button boton = new Button();
        boton.setText("Insert Coin");
        rootPane.setCenter(boton);

        stage.show();
    }
}
