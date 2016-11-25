package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class EscenaBatalla extends Scene {

    static Pane pane = new VBox();

    public EscenaBatalla(Stage stage) {
        super(pane, 480, 480);

        HBox paneNos = new HBox();
        HBox paneEllos = new HBox();
        VBox paneControles = new VBox();

        Algomon a = Especie.BULBASAUR.nuevo();
        Algomon b = Especie.CHARMANDER.nuevo();

        {
            AlgomonVistaImagen avi = new AlgomonVistaImagen(a);
            AlgomonVistaVida avv = new AlgomonVistaVida(a);
            avi.mostrarEspalda();
            paneNos.getChildren().addAll(avi, avv);
        }
        {
            AlgomonVistaImagen avi = new AlgomonVistaImagen(b);
            AlgomonVistaVida avv = new AlgomonVistaVida(b);
            paneEllos.getChildren().addAll(avv, avi);
        }

        {
            Button damBttnA = new Button();
            damBttnA.setOnAction(e -> {
                   a.causarDanio(10);
            });

            Button damBttnB = new Button();
            damBttnB.setOnAction(e -> {
                   b.causarDanio(10);
            });

            paneControles.getChildren().addAll(damBttnA, damBttnB);
        }

        pane.getChildren().addAll(paneEllos, paneNos, paneControles);
    }
}
