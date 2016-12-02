package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.AlgomonCambioControlador;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AlgomonVistaBoton extends Button {

    public AlgomonVistaBoton(Pane panel, Algomon algomon) {
        setText(algomon.nombreEspecie());
        setOnAction(new AlgomonCambioControlador(this, panel, algomon));
    }
}