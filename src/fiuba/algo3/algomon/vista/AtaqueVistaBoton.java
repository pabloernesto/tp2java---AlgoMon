package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AtaqueVistaBoton extends Button {

    AtaqueVistaBoton(Pane panel, Ataque a) {
        super(a.movimiento().name());
        setOnAction(e -> {
            Juego j = Juego.instancia();
            Algomon atacante = j.turno().getAlgomonActivo();
            Algomon enemigo = j.jugadorNoActivo().getAlgomonActivo();
            atacante.atacar(enemigo, a.movimiento());
            j.pasarTurno();
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}