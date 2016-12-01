package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.modelo.elementos.Item;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PantallaBatalla extends Scene {

    private Ejecutar aplicacion;
    public Juego juego;
    private static FlowPane     rootPane = new FlowPane();
    private static BorderPane   panelEnemigo, panelActivo;
    Pane panelOpciones = new Pane();


    public PantallaBatalla(Ejecutar ejecutar) {
        super(rootPane,500,600);

        aplicacion = ejecutar;
        juego = Juego.instancia();

        dibujarPantalla();
    }

    private void dibujarPantalla() {
        mostrarPanelEnemigo();
        mostrarPanelActivo();
        mostrarOpciones();
        Label copyright = new Label("Algomon 2.0 - All rights reserved - FIUBA Dec.2016");
        copyright.setPrefWidth(500);
        rootPane.getChildren().add(copyright);
    }

    private void mostrarPanelEnemigo() {
        panelEnemigo = new BorderPane();
        panelEnemigo.setStyle("-fx-background-color: #ff0000");
        panelEnemigo.setPrefSize(500, 180);

        Label nombre;
        ImageView imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            Algomon enemigo = juego.jugadorNoActivo().getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(enemigo).mostrarFrente();
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
        panelActivo.setPrefSize(500, 180);

        Label nombre;
        ImageView imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            Algomon activo = juego.turno().getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(activo).mostrarEspalda();
            barraVida = new AlgomonVistaVida(activo);
            nombre = new Label(activo.nombreEspecie());
        }
        panelActivo.setCenter(imgAlgomon);
        panelActivo.setBottom(nombre);
        panelActivo.setTop(barraVida);

        rootPane.getChildren().add(panelActivo);
    }

    private void mostrarOpciones() {
        panelOpciones.setStyle("-fx-background-color: #ffffff");
        panelOpciones.setPrefSize(500,220);
        rootPane.getChildren().add(panelOpciones);
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

        for (Item i : Juego.instancia().turno().mochila()) {
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