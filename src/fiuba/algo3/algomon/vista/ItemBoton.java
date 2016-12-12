package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.control.ItemControlador;
import fiuba.algo3.algomon.modelo.elementos.Item;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ItemBoton extends Button {

    public ItemBoton(Pane panel, Item item, Ejecutar app) {
        super(item.getNombreParaMostrar());
        setOnAction(new ItemControlador(panel, item, app));
        if (item.usosRestantes() == 0)
            setDisable(true);
    }
}
