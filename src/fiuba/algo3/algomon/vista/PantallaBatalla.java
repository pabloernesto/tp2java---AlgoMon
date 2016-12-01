package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaBatalla extends Scene {

    private Ejecutar aplicacion;
    private static FlowPane     rootPane = new FlowPane();
    private static BorderPane   panelEnemigo, panelActivo;
    Pane panelOpciones = new Pane();


    public PantallaBatalla(Ejecutar ejecutar) {
        super(rootPane,690,500);

        aplicacion = ejecutar;
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
            Algomon enemigo = Juego.instancia().jugador(1).getAlgomonActivo();
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
            Algomon activo = Juego.instancia().jugador(0).getAlgomonActivo();
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

        algomon.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Algomones(panel));
        });

        mochila.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new Mochila(panel));
        });

        pasarTurno.setOnAction(e -> {
            Juego.instancia().pasarTurno();
        });
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
                .turno()
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

class Algomones extends GridPane {

    Algomones(Pane panel) {
        setStyle("-fx-background-color: #ffffff");
        setHgap(20);
        setVgap(20);

        Button algomon1, algomon2, algomon3, volver;
        algomon1 = new Button();
        algomon2 = new Button();
        algomon3 = new Button();
        volver = new Button("Volver");

        add(algomon1, 1, 1);
        add(algomon2, 3, 1);
        add(algomon3, 1, 3);
        add(volver, 3, 3);

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

        Button volver = new Button("Volver");

        getChildren().add(volver);

        volver.setOnAction(e -> {
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}

class AtaqueVistaBoton extends Button {

    AtaqueVistaBoton(Pane panel, Ataque a) {
        super(a.movimiento().name());
        setOnAction(e -> {
            Juego j = Juego.instancia();
            Algomon atacante = j.turno().getAlgomonActivo();
            Algomon enemigo = j.jugadorNoActivo().getAlgomonActivo();
            atacante.atacar(enemigo, a.movimiento());
            j.pasarTurno();
            panel.getChildren().clear();
            panel.getChildren().add(new OpcionesJugador(panel));
        });
    }
}
