package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.vista.AtaqueVistaBoton;
import fiuba.algo3.algomon.vista.OpcionesJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AtaqueControlador implements EventHandler<ActionEvent> {

    private Button miboton;
    private Pane panel;
    private Ataque ataque;

    public AtaqueControlador(AtaqueVistaBoton ataqueVistaBoton, Pane panel, Ataque a) {
        this.miboton = (Button)ataqueVistaBoton;
        this.panel = panel;
        this.ataque = a;
    }

    @Override
    public void handle(ActionEvent event) {
            Juego j = Juego.instancia();
            Algomon atacante = j.obtenerJugadorActivo().getAlgomonActivo();
            Algomon enemigo = j.jugadorNoActivo().getAlgomonActivo();
            atacante.atacar(enemigo, ataque.movimiento());
            j.pasarTurno();
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
}

}