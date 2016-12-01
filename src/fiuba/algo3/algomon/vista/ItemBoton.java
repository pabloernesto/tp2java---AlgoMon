package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.AtaqueControlador;
import fiuba.algo3.algomon.modelo.elementos.Item;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ItemBoton extends Button {
        
    public ItemBoton(Pane panel, Item item) {
             super(item.nombre());
             //setOnAction();
    }
}
