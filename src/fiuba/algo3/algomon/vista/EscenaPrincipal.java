package fiuba.algo3.algomon.vista;

import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EscenaPrincipal extends Scene {

    static BorderPane rootPane = new BorderPane();
    private Stage stage;

    public EscenaPrincipal(Stage stage) {
        super(rootPane,300,275);
        this.stage = stage;

        Button boton = new Button();
        boton.setText("Insert Coin");
        boton.setOnAction(e-> {
               stage.setScene(new CrearJugador(stage)); 
        });;
        rootPane.setCenter(boton);
    }


}
