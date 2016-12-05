package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.modelo.elementos.Item;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PantallaBatalla extends Scene {

    private Ejecutar aplicacion;
    public Juego juego;
    private static BorderPane rootPane = new BorderPane(); 
    private static FlowPane     pantalla = new FlowPane();
    Pane panelActivo, panelEnemigo;
    Pane panelOpciones = new Pane();


    public PantallaBatalla(Ejecutar ejecutar) {
        super(rootPane,500,600);

        this.aplicacion = ejecutar;
        this.juego = Juego.instancia();
        
        rootPane.setTop(aplicacion.barraDeMenu());
        rootPane.setCenter(pantalla);

        dibujarPantalla();
    }

    private void dibujarPantalla() {
        mostrarBatalla();
        mostrarOpciones();
        
        Label copyright = new Label("Algomon 2.0 - All rights reserved - FIUBA Dec.2016");
        copyright.setPrefWidth(500);
        pantalla.getChildren().add(copyright);
    }

    private void mostrarBatalla(){
    	VBox batalla = new VBox();
    	
    	crearPanelEnemigo();
    	batalla.getChildren().add(panelEnemigo);
    	crearPanelActivo();
    	batalla.getChildren().add(panelActivo);

    	// Ahi va el fondo que le quieran poner a la batalla 
    	batalla.setStyle("-fx-background-image: url('images/algomon.png'); " +
    	           		"-fx-background-position: center center; " +
    	           		"-fx-background-repeat: stretch;");
    	
    	pantalla.getChildren().add(batalla);
    }
    
    private void crearPanelEnemigo() {
        panelEnemigo = new JugadorVistaAlgomonActivo(
            Juego.instancia().jugadorNoActivo());
    }

    private void crearPanelActivo() {
        panelActivo = new JugadorVistaAlgomonActivo(
            Juego.instancia().obtenerJugadorActivo());
    }

    private void mostrarOpciones() {
        panelOpciones.setStyle("-fx-background-color: #ffffff");
        panelOpciones.setPrefSize(500,220);
        pantalla.getChildren().add(panelOpciones);
        panelOpciones.getChildren().add(new OpcionesJugador(panelOpciones));
    }
}


class Ataques extends GridPane {

    Ataques(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setHgap(20);
        setVgap(20);

        Button ataque1, ataque2, ataque3, volver;
        {
            Ataque[] a = Juego
                .instancia()
                .obtenerJugadorActivo()
                .getAlgomonActivo()
                .ataques();
            ataque1 = new AtaqueVistaBoton(panel, a[0]);
            ataque2 = new AtaqueVistaBoton(panel, a[1]);
            ataque3 = new AtaqueVistaBoton(panel, a[2]);
        }
        volver = new Button("Volver");

        add(ataque1, 1, 1);
        add(ataque2, 3, 1);
        add(ataque3, 1, 3);
        add(volver, 3, 3);

        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}

class Algomones extends VBox {

    Algomones(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setSpacing(20);

        for (Algomon a : Juego.instancia().obtenerJugadorActivo().getAlgomones())
            getChildren().add(new AlgomonVistaBoton(panel, a));

        Button volver = new Button("Volver");
        getChildren().add(volver);
        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}

class Mochila extends VBox {

    Mochila(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setSpacing(20);

        for (Item i : Juego.instancia().obtenerJugadorActivo().mochila()) {
            getChildren().add(new ItemBoton(panel, i));
        }

        Button volver = new Button("Volver");
        getChildren().add(volver);
        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}
