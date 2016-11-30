package fiuba.algo3.algomon.control;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.vista.PantallaBatalla;
import fiuba.algo3.algomon.vista.PantallaEleccionAlgomones;
import fiuba.algo3.algomon.vista.PantallaInicio;
import fiuba.algo3.algomon.vista.PantallaJugador;
import javafx.application.Application;
import javafx.stage.Stage;

public class Ejecutar extends Application implements Observer {

    private Stage ventana;
    private Juego modelo;

    @Override
    public void start (Stage stage) {
        ventana = stage;
        modelo = new Juego();

        ventana.setTitle ("Algomon 2.0 BETA Version");
        ventana.setResizable(false);
        ventana.show();

        mostrarBarraDeMenu();

        crearPantallaInicio();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void mostrarBarraDeMenu() {
//      MenuBar menuBar = new MenuBar();
//
//          Menu sonido = new Menu("Sonido");
//              MenuItem itmActivado = new MenuItem("Activado");
//              MenuItem itmDesactivado = new MenuItem("Desactivado");
//          sonido.getItems().addAll(itmActivado,itmDesactivado);
//
//          Menu salir = new Menu("Salir");
//
//      menuBar.getMenus().addAll(sonido,salir);
//
//      root.setTop(menuBar);
//      ventana.setScene(new Scene(root,480,480));

//      TODO Que se vea
    }

    private void crearPantallaInicio() {
        ventana.setScene (new PantallaInicio(ventana, this));
    }

    public void crearPantallaJugadores() {
        ventana.setScene(new PantallaJugador(ventana, this));
    }

    public void crearPantallaEleccionAlgomones() {
        ventana.setScene(new PantallaEleccionAlgomones(ventana, this));
    }

    public void crearPantallaBatalla() {
        ventana.setScene(new PantallaBatalla(this));
    }

    public Juego getModelo() {
        return this.modelo;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO
    }





}
