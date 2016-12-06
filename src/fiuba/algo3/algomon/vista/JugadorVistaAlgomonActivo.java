package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Jugador;

import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaEstados;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class JugadorVistaAlgomonActivo extends BorderPane implements Observer {

    Jugador jugador;

    public JugadorVistaAlgomonActivo(Jugador j) {
        jugador = j;
        jugador.addObserver(this);
        update(jugador, null);
    }

    public void update(Observable j, Object arg) {
        getChildren().clear();

        Algomon activo = jugador.getAlgomonActivo();
        
        actualizarVista(activo);
    }

	private void actualizarVista(Algomon activo) {
		Label nombre = new Label(activo.nombreEspecie());		
			nombre.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 18;");
			nombre.setAlignment(Pos.TOP_CENTER);
		setTop(nombre);
		
		setCenter(new AlgomonVistaImagen(activo).mostrarFrente());
        
		setRight(new AlgomonVistaEstados(activo));
		
		setBottom(new AlgomonVistaVida());
	}
}
