package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.vista.AlgomonVistaBoton;
import fiuba.algo3.algomon.vista.OpcionesJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AlgomonCambioControlador implements EventHandler<ActionEvent> {

    private Ejecutar aplicacion;
	@SuppressWarnings("unused")
	private Button miboton;
    private Pane panel;
    private Algomon algomon;

    public AlgomonCambioControlador(AlgomonVistaBoton algomonVistaBoton, Pane panel, Algomon algomon, Ejecutar app) {
        this.miboton = (Button)algomonVistaBoton;
        this.panel = panel;
        this.algomon = algomon;
        this.aplicacion = app;
    }

    @Override
    // todavia no esta la logica del cambio de algomon;
    public void handle(ActionEvent arg0) {
        Jugador jugador = Juego.instancia().obtenerJugadorActivo();
		jugador.cambiarAlgomonActivoPor(this.algomon);
		panel.getChildren().clear();
		panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
    }

}
