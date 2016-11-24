package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EscenaBatalla extends Scene {

    static Pane pane = new VBox();

    public EscenaBatalla(Stage stage) {
        super(pane, 480, 480);

        Algomon a = Especie.BULBASAUR.nuevo();
        AlgomonVistaVida avv = new AlgomonVistaVida(a);

        Button damBttn = new Button();
        damBttn.setOnAction(e -> {
               a.causarDanio(10);
        });

        pane.getChildren().addAll(avv, damBttn);
    }
}
