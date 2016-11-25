package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;

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

        VBox paneControles = new VBox();

        {
            Button damBttnA = new Button();
            damBttnA.setOnAction(e -> {
                Algomon a =
                    Juego
                        .instancia()
                        .jugador(0)
                        .getAlgomonActivo();
                a.causarDanio(10);
            });

            Button damBttnB = new Button();
            damBttnB.setOnAction(e -> {
                Algomon a =
                    Juego
                        .instancia()
                        .jugador(1)
                        .getAlgomonActivo();
                a.causarDanio(10);
            });

            paneControles.getChildren().addAll(damBttnA, damBttnB);
        }

        pane
            .getChildren()
            .addAll(new VistaAlgomonesPrincipales(), paneControles);
    }
}

class VistaAlgomonesPrincipales extends VBox {

    VistaAlgomonesPrincipales() {
        HBox paneNos = new HBox();
        HBox paneEllos = new HBox();

        {
            Algomon a =
                Juego
                    .instancia()
                    .jugador(0)
                    .getAlgomonActivo();
            AlgomonVistaImagen avi = new AlgomonVistaImagen(a);
            AlgomonVistaVida avv = new AlgomonVistaVida(a);
            avi.mostrarEspalda();
            paneNos.getChildren().addAll(avi, avv);
        }
        {
            Algomon b =
                Juego
                    .instancia()
                    .jugador(1)
                    .getAlgomonActivo();
            AlgomonVistaImagen avi = new AlgomonVistaImagen(b);
            AlgomonVistaVida avv = new AlgomonVistaVida(b);
            paneEllos.getChildren().addAll(avv, avi);
        }
        getChildren().addAll(paneEllos, paneNos);
    }
}
