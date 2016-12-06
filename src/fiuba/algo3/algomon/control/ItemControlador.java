package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.elementos.Item;
import fiuba.algo3.algomon.vista.ItemBoton;
import fiuba.algo3.algomon.vista.OpcionesJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ItemControlador implements EventHandler<ActionEvent> {
    private Item item;
    @SuppressWarnings("unused")
	private Button miboton;
    private Pane panel;
    private Ejecutar aplicacion;
    
    public ItemControlador(ItemBoton itemBoton, Pane panel, Item item2, Ejecutar app) {
        this.aplicacion = app;
        this.miboton = (Button)itemBoton;
        this.panel = panel;
        this.item = item2;
    }

    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Juego j = Juego.instancia();
        Jugador jugador = j.obtenerJugadorActivo();
        jugador.aplicar(item.elemento());
        panel.getChildren().clear();
        panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
    }

}
