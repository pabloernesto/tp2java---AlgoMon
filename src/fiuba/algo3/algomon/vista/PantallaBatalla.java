package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.vista.AlgomonVistaImagen;
import fiuba.algo3.algomon.vista.AlgomonVistaVida;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

//      Label lblNombreEspecie = new Label(juego.jugadorNoActivo().getAlgomonActivo().getNombre());
//      panelEnemigo.setTop(lblNombreEspecie);

        AlgomonVistaImagen imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            fiuba.algo3.algomon.modelo.Algomon enemigo
                = juego.jugador(1).getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(enemigo);
            barraVida = new AlgomonVistaVida(enemigo);
        }
        panelEnemigo.setCenter(imgAlgomon);
        panelEnemigo.setBottom(barraVida);

        rootPane.getChildren().add(panelEnemigo);
    }

    private void mostrarPanelActivo() {
        panelActivo = new BorderPane();
        panelActivo.setStyle("-fx-background-color: #ffff00");

//      Label lblNombreEspecie = new Label(juego.turno().getAlgomonActivo().getNombre());
        AlgomonVistaImagen imgAlgomon;
        AlgomonVistaVida barraVida;
        {
            fiuba.algo3.algomon.modelo.Algomon enemigo
                = juego.jugador(0).getAlgomonActivo();
            imgAlgomon = new AlgomonVistaImagen(enemigo);
            barraVida = new AlgomonVistaVida(enemigo);
        }
        panelActivo.setCenter(imgAlgomon);
        panelActivo.setBottom(barraVida);

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
