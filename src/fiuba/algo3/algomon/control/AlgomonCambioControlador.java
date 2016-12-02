package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.vista.AlgomonVistaBoton;
import fiuba.algo3.algomon.vista.OpcionesJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AlgomonCambioControlador implements EventHandler<ActionEvent> {

    private Button miboton;
    private Pane panel;
    private Algomon algomon;

    public AlgomonCambioControlador(AlgomonVistaBoton algomonVistaBoton, Pane panel, Algomon algomon) {
        this.miboton = (Button)algomonVistaBoton;
        this.panel = panel;
        this.algomon = algomon;
    }

    @Override
    // todavia no esta la logica del cambio de algomon;
    public void handle(ActionEvent arg0) {
        Juego.instancia().pasarTurno();
        panel.getChildren().clear();
        panel.getChildren().add(new OpcionesJugador(panel));
    }

}
