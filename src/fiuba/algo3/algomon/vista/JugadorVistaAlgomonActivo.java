package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Jugador;

import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaEstados;

import java.util.Observable;
import java.util.Observer;
import java.util.function.Function;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class JugadorVistaAlgomonActivo extends BorderPane implements Observer {

    Jugador jugador;
    Function<Algomon, AlgomonVistaImagen> fabricaImagenes;

    public JugadorVistaAlgomonActivo(Jugador j) {
        jugador = j;
        jugador.addObserver(this);
        mostrarFrente();
    }

    public void update(Observable j, Object arg) {
        getChildren().clear();

        Algomon activo = jugador.getAlgomonActivo();

        actualizarVista(activo);
    }

    private void actualizarVista(Algomon activo) {
        Label nombre = new Label(activo.getNombreEspecie());
            nombre.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold ; -fx-font-size: 20;");
            nombre.setPrefSize(500, 50);
            nombre.setAlignment(Pos.CENTER);
        setTop(nombre);

        setCenter(fabricaImagenes.apply(activo));

        HBox hb = new HBox();
        	hb.setPrefSize(80, 60);
        setLeft(hb);
        
        AlgomonVistaEstados estados = new AlgomonVistaEstados(activo);
        	estados.setPrefSize(80, 60);
        	estados.setStyle("-fx-padding: 4px");
        setRight(estados);
        
        HBox vida = new HBox();
        	vida.setPrefSize(500, 40);
        	vida.setAlignment(Pos.CENTER);
        	vida.getChildren().add(new AlgomonVistaVida(activo));
        setBottom(vida);
    }

    public void mostrarFrente() {
        fabricaImagenes = activo -> {
            return new AlgomonVistaImagen(activo).mostrarFrente();
        };
        update(jugador, null);
    }

    public void mostrarEspalda() {
        fabricaImagenes = activo -> {
            return new AlgomonVistaImagen(activo).mostrarEspalda();
        };
        update(jugador, null);
    }
}
