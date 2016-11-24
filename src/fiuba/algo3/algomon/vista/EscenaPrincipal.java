package fiuba.algo3.algomon.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EscenaPrincipal extends Scene {

    static BorderPane rootPane = new BorderPane();

    public EscenaPrincipal(Stage stage) {
        super(rootPane, 480, 480);

        // button creation
        Image imgLogo = new Image("resources/images/pokemon-logo.png");
        Button btnStart = new Button();
        btnStart.setGraphic(new ImageView(imgLogo));
        btnStart.setStyle("-fx-base:#ffffff");
        btnStart.setOnAction(e-> {
               stage.setScene(new CrearJugador(stage));
        });;
        rootPane.setCenter(btnStart);
    }
}
