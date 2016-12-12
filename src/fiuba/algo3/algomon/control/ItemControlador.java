package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.elementos.Item;
import fiuba.algo3.algomon.vista.OpcionesJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class ItemControlador implements EventHandler<ActionEvent> {
    private Item item;
    private Pane panel;
    private Ejecutar aplicacion;
    
    public ItemControlador(Pane panel, Item item, Ejecutar app) {
        this.aplicacion = app;
        this.panel = panel;
        this.item = item;
    }

    @Override
    public void handle(ActionEvent arg0) {
        Juego j = Juego.instancia();
        Jugador jugador = j.obtenerJugadorActivo();
        jugador.aplicar(item.elemento());
        panel.getChildren().clear();
        panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
    }

}
