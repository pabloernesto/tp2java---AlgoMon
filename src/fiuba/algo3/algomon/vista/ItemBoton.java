package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.AtaqueControlador;
<<<<<<< HEAD
import fiuba.algo3.algomon.modelo.elementos.Item;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ItemBoton extends Button {
        
    public ItemBoton(Pane panel, Item item) {
             super(item.nombre());
             //setOnAction();
=======
import fiuba.algo3.algomon.control.ItemControlador;
import fiuba.algo3.algomon.modelo.elementos.Item;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ItemBoton extends Button {
        
    public ItemBoton(Pane panel, Item item) {
             super(item.nombre());
             setOnAction(new ItemControlador(this, panel, item));
>>>>>>> branch 'master' of https://github.com/pabloernesto/tp2java---AlgoMon.git
    }
}
