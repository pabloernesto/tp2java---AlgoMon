package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;

import fiuba.algo3.algomon.vista.OpcionesJugador;

import fiuba.algo3.algomon.excepciones.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class AtaqueControlador implements EventHandler<ActionEvent> {

    private Pane panel;
    private Ataque ataque;
	private Ejecutar aplicacion;

    public AtaqueControlador(Pane panel, Ataque a, Ejecutar app) {
        this.panel = panel;
        this.ataque = a;
        this.aplicacion = app;
    }

    @Override
    public void handle(ActionEvent event) {
        Juego j = Juego.instancia();
        Algomon atacante = j.obtenerJugadorActivo().getAlgomonActivo();
        Algomon enemigo = j.obtenerJugadorNoActivo().getAlgomonActivo();

        try {
            atacante.atacar(enemigo, ataque.movimiento());
        }
        catch (AlgomonEstaInhabilitadoParaAtacarException e) {
            //~ ???
        }
        catch (juegoTerminadoException e){
    		aplicacion.mostrarPantallaFin();
        }
        j.pasarTurno();
        panel.getChildren().clear();
        panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
    }
}
