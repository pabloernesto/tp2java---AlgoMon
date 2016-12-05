package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Jugador;

import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaEstados;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.VBox;

import javafx.scene.control.Label;

public class JugadorVistaAlgomonActivo extends VBox implements Observer {

    Jugador jugador;

    public JugadorVistaAlgomonActivo(Jugador j) {
        jugador = j;
        jugador.addObserver(this);
        update(jugador, null);
    }

    public void update(Observable j, Object arg) {
        getChildren().clear();

        Algomon activo = jugador.getAlgomonActivo();
        getChildren().add(new AlgomonVistaVida(activo));
        getChildren().add(new AlgomonVistaImagen(activo).mostrarFrente());
        getChildren().add(new Label(activo.nombreEspecie()));
        getChildren().add(new AlgomonVistaEstados(activo));
    }
}
