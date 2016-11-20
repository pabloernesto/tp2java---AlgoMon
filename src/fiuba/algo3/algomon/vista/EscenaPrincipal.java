package fiuba.algo3.algomon.vista;

import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class EscenaPrincipal extends Scene {

    static BorderPane rootPane = new BorderPane();

    public EscenaPrincipal() {
        super(rootPane,300,275);

        Button boton = new Button();
        boton.setText("Insert Coin");
        rootPane.setCenter(boton);
    }


}
