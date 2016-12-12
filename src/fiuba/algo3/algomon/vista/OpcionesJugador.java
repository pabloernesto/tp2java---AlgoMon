package fiuba.algo3.algomon.vista;

import java.util.ArrayList;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OpcionesJugador extends GridPane {

    public OpcionesJugador(Pane panel, Ejecutar aplicacion) {
    	if(!Juego.instancia().jugadorActivoPuedeContinuar()){
    		aplicacion.mostrarPantallaFin();
    	}
    	else{
    		setStyle("-fx-background-color:#000000");
			
    		
    		Button atacar = new Button("Atacar");
			Button algomon = new Button("Algomon");
			Button mochila = new Button("Mochila");
			Button pasarTurno = new Button("Pasar turno");
		 
			add(atacar, 0, 0);
			add(algomon, 0, 1);
			add(mochila, 1, 0);
			add(pasarTurno, 1, 1);

			ArrayList<Button> botones = new ArrayList<Button>();
			botones.add(atacar);	botones.add(algomon);	botones.add(mochila);	botones.add(pasarTurno);
			
			for (Button b : botones) {
				b.setPrefSize(250, 100);
				b.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;"); 
			}
			
			atacar.setOnAction(e -> {
				panel.getChildren().clear();
				panel.getChildren().add(new Ataques(panel, aplicacion));
			});

			algomon.setOnAction(e -> {
				panel.getChildren().clear();
				panel.getChildren().add(new Algomones(panel,aplicacion));
			});

			mochila.setOnAction(e -> {
				panel.getChildren().clear();
				panel.getChildren().add(new Mochila(panel, aplicacion));
			});

			pasarTurno.setOnAction(e -> {
				Juego.instancia().pasarTurno();
			});
    	}
    }
}