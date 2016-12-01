package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

class OpcionesJugador extends GridPane {

    OpcionesJugador(Pane panel) {
        setHgap(20);
        setVgap(20);

        Button atacar = new Button("Atacar");
        Button algomon = new Button("Algomon");
        Button mochila = new Button("Mochila");
        Button pasarTurno = new Button("Pasar turno");

        add(atacar, 1, 1);
        add(algomon, 3, 1);
        add(mochila, 1, 3);
        add(pasarTurno, 3, 3);

        atacar.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Ataques(panel));
        });

        algomon.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Algomones(panel));
        });

        mochila.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Mochila(panel));
        });

        pasarTurno.setOnAction(e -> {
            Juego.instancia().pasarTurno();
        });
    }
}