package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private static GridPane     panelOpciones;

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
        panelOpciones = new GridPane();
        panelOpciones.setStyle("-fx-background-color: #ffffff");

        panelOpciones.setHgap(20);
        panelOpciones.setVgap(20);

        Button btnAtacar = new Button("Atacar (...)");
        Button btnCambiarAlgomon = new Button("Cambiar algomon");
        Button btnAplicarElemento = new Button("Aplicar elemento (...)");
        Button btnPasarTurno = new Button("Pasar turno");

        panelOpciones.add(btnAtacar,1,1);
        panelOpciones.add(btnCambiarAlgomon,3,1);
        panelOpciones.add(btnAplicarElemento,1,3);
        panelOpciones.add(btnPasarTurno,3,3);

        rootPane.getChildren().add(panelOpciones);
    }
}
