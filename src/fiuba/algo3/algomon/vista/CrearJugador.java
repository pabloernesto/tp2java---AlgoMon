package fiuba.algo3.algomon.vista;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrearJugador extends Scene {
static BorderPane rootPane = new BorderPane();
private Stage stage;

public CrearJugador(Stage stage) {
    super(rootPane,300,275);
    this.stage = stage;

    Label label = new Label("Escribe to nombre: ");
    rootPane.setTop(label);
    BorderPane.setAlignment(label, Pos.CENTER);

    // escribe
    
    Button boton = new Button();
    boton.setText("Continuar");
    boton.setOnAction(e-> {
           stage.setScene(new CrearJugador(stage)); 
    });
    rootPane.setBottom(boton);
    BorderPane.setAlignment(boton, Pos.CENTER);
}


}
