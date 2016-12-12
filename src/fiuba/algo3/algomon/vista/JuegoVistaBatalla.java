package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.vista.JugadorVistaAlgomonActivo;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.VBox;

public class JuegoVistaBatalla extends VBox implements Observer {

    Juego juego;

    public JuegoVistaBatalla() {
        juego = Juego.instancia();
        juego.addObserver(this);

        Jugador activo, inactivo;
        activo = juego.obtenerJugadorActivo();
        inactivo = juego.obtenerJugadorNoActivo();

        JugadorVistaAlgomonActivo vistaActivo, vistaInactivo;
        vistaActivo = new JugadorVistaAlgomonActivo(activo);
        vistaActivo.mostrarEspalda();
        vistaInactivo = new JugadorVistaAlgomonActivo(inactivo);

        getChildren().addAll(vistaInactivo, vistaActivo);

        setStyle("-fx-background-image: url('images/bosque.png'); "
                 + "-fx-background-position: center center; "
                 + "-fx-background-repeat: stretch;");
    }

    public void update(Observable j, Object arg) {
        JugadorVistaAlgomonActivo tmp;

        tmp = (JugadorVistaAlgomonActivo) getChildren().get(1);
        tmp.mostrarFrente();

        tmp = (JugadorVistaAlgomonActivo) getChildren().get(0);
        tmp.mostrarEspalda();

        getChildren().remove(0);
        getChildren().add(tmp);
    }
}
