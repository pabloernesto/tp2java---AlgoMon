package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.AtaqueControlador;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AtaqueVistaBoton extends Button {

    AtaqueVistaBoton(Pane panel, Ataque a, Ejecutar app) {
        super(a.nombre());
        setOnAction(new AtaqueControlador(panel, a, app));
    }
}
