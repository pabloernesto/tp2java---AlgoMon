package fiuba.algo3.algomon.vista;

import java.util.ArrayList;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.modelo.elementos.Item;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PantallaBatalla extends Scene {

    private Ejecutar aplicacion;
    public Juego juego;

    private static BorderPane   rootPane = new BorderPane();
    private static FlowPane     pantalla = new FlowPane();

    JugadorVistaAlgomonActivo panelActivo, panelEnemigo;
    Pane panelOpciones = new Pane();


    public PantallaBatalla(Ejecutar ejecutar) {
        super(rootPane,500,600);

        this.aplicacion = ejecutar;
        this.juego = Juego.instancia();
        
        rootPane.setStyle("-fx-background-color: #000000");
        rootPane.setTop(aplicacion.barraDeMenu());
        rootPane.setCenter(pantalla);

        dibujarPantalla();
    }

    private void dibujarPantalla() {
        mostrarBatalla();
        mostrarOpciones();
        
        Label copyright = new Label("Algomon 2.0 - All rights reserved - FIUBA Dec.2016");
	        copyright.setAlignment(Pos.CENTER);
	        copyright.setStyle("-fx-text-fill: #ffcc00; -fx-font-size: 12");
	        copyright.setPrefSize(500,40);
        pantalla.getChildren().add(copyright);
    }

    private void mostrarBatalla(){
    	VBox batalla = new VBox();
    		batalla.setPrefSize(500, 340);
    	
    	crearPanelEnemigo();
    		batalla.getChildren().add(panelEnemigo);
    	crearPanelActivo();
    		batalla.getChildren().add(panelActivo);

    		batalla.setStyle("-fx-background-image: url('images/bosque.png'); " +
    	           			"-fx-background-position: center center; " +
    	           			"-fx-background-repeat: stretch;");
    	
    	pantalla.getChildren().add(batalla);
    }
    
    private void crearPanelEnemigo() {
        panelEnemigo = new JugadorVistaAlgomonActivo(Juego.instancia().obtenerJugadorNoActivo());
        panelEnemigo.setPrefSize(500, 160);
    }

    private void crearPanelActivo() {
        panelActivo = new JugadorVistaAlgomonActivo(Juego.instancia().obtenerJugadorActivo());
        	panelActivo.mostrarEspalda();
        panelActivo.setPrefSize(500, 160);
    }

    private void mostrarOpciones() {
    	panelOpciones.setPrefSize(500,160);
    	panelOpciones.getChildren().add(new OpcionesJugador(panelOpciones, aplicacion));
    	
    	pantalla.getChildren().add(panelOpciones);
    }
}


class Ataques extends GridPane {

    Ataques(Pane panel, Ejecutar aplicacion) {
        setStyle("-fx-background-color: #000000");
       
        Button ataque1, ataque2, ataque3, volver;
        {
            Ataque[] a = Juego.instancia().obtenerJugadorActivo().getAlgomonActivo().getAtaques();
	            ataque1 = new AtaqueVistaBoton(panel, a[0], aplicacion);
	            ataque2 = new AtaqueVistaBoton(panel, a[1], aplicacion);
	            ataque3 = new AtaqueVistaBoton(panel, a[2], aplicacion);
	    }
        volver = new Button("Volver");

        
        ArrayList<Button> botones = new ArrayList<Button>();
        	botones.add(ataque1);	botones.add(ataque2);	botones.add(ataque3);
		for (Button b : botones) {
			b.setPrefSize(250, 80);
			b.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;"); 
		}
        
		volver.setPrefSize(250, 80);
		volver.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;-fx-font-weight: bold");
        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
        });        
        
        
        add(ataque1, 0, 0);
        add(ataque2, 0, 1);
        add(ataque3, 1, 0);
        add(volver, 1, 1);
    }
}

class Algomones extends GridPane {

    Algomones(Pane panel, Ejecutar aplicacion) {
        setStyle("-fx-background-color: #000000");
        
        Button algomon1, algomon2, algomon3, volver;
        {
            ArrayList<Algomon> a = Juego.instancia().obtenerJugadorActivo().getAlgomones();
	            algomon1 = new AlgomonVistaBoton(panel, a.get(0), aplicacion);
	            algomon2 = new AlgomonVistaBoton(panel, a.get(1), aplicacion);
	            algomon3 = new AlgomonVistaBoton(panel, a.get(2), aplicacion);
	    }
        volver = new Button("Volver");

        
        ArrayList<Button> botones = new ArrayList<Button>();
		botones.add(algomon1);	botones.add(algomon2);	botones.add(algomon3);
		for (Button b : botones) {
			b.setPrefSize(250, 80);
			b.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;"); 
		}
		
		volver.setPrefSize(250, 80);
		volver.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;-fx-font-weight: bold");
        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
        });
        
        
        add(algomon1, 0, 0);
        add(algomon2, 0, 1);
        add(algomon3, 1, 0);
        add(volver, 1, 1);
    }
}

class Mochila extends GridPane {

    Mochila(Pane panel, Ejecutar aplicacion) {
    	setStyle("-fx-background-color: #000000");
    	
        Button item1, item2, item3, volver;
        {
            Item[] i = Juego.instancia().obtenerJugadorActivo().getMochila();
	            item1 = new ItemBoton(panel, i[0], aplicacion);
	            item2 = new ItemBoton(panel, i[1], aplicacion);
	            item3 = new ItemBoton(panel, i[2], aplicacion);
	    }
        volver = new Button("Volver");
		
        
        ArrayList<Button> botones = new ArrayList<Button>();
			botones.add(item1);	botones.add(item2);	botones.add(item3);	botones.add(volver);
		for (Button b : botones) {
			b.setPrefSize(250, 80);
			b.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;"); 
		}
            
		volver.setPrefSize(250, 80);
		volver.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff; -fx-background-color: #000000;-fx-font-weight: bold");
        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel, aplicacion));
        });

		
        add(item1, 0, 0);
        add(item2, 0, 1);
        add(item3, 1, 0);
        add(volver, 1, 1);
    }
}
