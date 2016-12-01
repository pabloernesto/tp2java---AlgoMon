package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaBatalla extends Scene {

    private Ejecutar aplicacion;
    public Juego juego;
    private static FlowPane     rootPane = new FlowPane();
    private static BorderPane   panelEnemigo, panelActivo;
    Pane panelOpciones = new Pane();


    public PantallaBatalla(Ejecutar ejecutar) {
        super(rootPane,690,500);

        aplicacion = ejecutar;
        juego = aplicacion.getModelo();

        dibujarPantalla();

    }

    private void dibujarPantalla() {
        mostrarPanelEnemigo();
        mostrarPanelActivo();
        mostrarOpciones();
    }

    private void mostrarPanelEnemigo() {
        panelEnemigo = new BorderPane();
        panelEnemigo.setStyle("-fx-background-color: #ff0000");

        Label nombre;
        AlgomonVistaImagen imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            Algomon enemigo = juego.jugador(1).getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(enemigo);
            barraVida = new AlgomonVistaVida(enemigo);
            nombre = new Label(enemigo.nombreEspecie());
        }
        panelEnemigo.setCenter(imgAlgomon);
        panelEnemigo.setBottom(barraVida);
        panelEnemigo.setTop(nombre);

        rootPane.getChildren().add(panelEnemigo);
    }

    private void mostrarPanelActivo() {
        panelActivo = new BorderPane();
        panelActivo.setStyle("-fx-background-color: #ffff00");

        Label nombre;
        AlgomonVistaImagen imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            Algomon activo = juego.jugador(0).getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(activo);
            barraVida = new AlgomonVistaVida(activo);
            nombre = new Label(activo.nombreEspecie());
        }
        panelActivo.setCenter(imgAlgomon);
        panelActivo.setBottom(barraVida);
        panelActivo.setTop(nombre);

        rootPane.getChildren().add(panelActivo);
    }

    private void mostrarOpciones() {
        rootPane.getChildren().add(panelOpciones);
        panelOpciones.getChildren().add(new OpcionesJugador(panelOpciones));
    }
}

class OpcionesJugador extends GridPane {

    OpcionesJugador(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setHgap(20);
        setVgap(20);

        Button atacar = new Button("Atacar");
        Button algomon = new Button("Algomon");
        Button mochila = new Button("Mochila");
        Button pasarTurno = new Button("Pasar turno");

        add(atacar, 1, 1);
        add(algomon, 3, 1);
        add(mochila, 1, 3);
        add(pasarTurno, 3, 3);

        atacar.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Ataques(panel));
        });
    }
}

class Ataques extends GridPane {

    Ataques(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setHgap(20);
        setVgap(20);

        Button ataque1, ataque2, ataque3, volver;
        ataque1 = new Button();
        ataque2 = new Button();
        ataque3 = new Button();
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
