package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.AlgomonCambioControlador;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AlgomonVistaBoton extends Button {

    public AlgomonVistaBoton(Pane panel, Algomon algomon, Ejecutar app) {
        setText(algomon.nombreEspecie());
        setOnAction(new AlgomonCambioControlador(this, panel, algomon, app));
        if (!algomon.puedePelear())
            setDisable(true);
    }
}