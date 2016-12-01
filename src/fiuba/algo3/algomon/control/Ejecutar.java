package fiuba.algo3.algomon.control;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.algomon.vista.PantallaBatalla;
import fiuba.algo3.algomon.vista.PantallaEleccionAlgomones;
import fiuba.algo3.algomon.vista.PantallaInicio;
import fiuba.algo3.algomon.vista.PantallaJugador;
import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Ejecutar extends Application implements Observer {

    private Stage ventana;
    private MenuBar menuBar;

    @Override
    public void start (Stage stage) {
        ventana = stage;

        ventana.setTitle ("Algomon 2.0 BETA Version");
        ventana.setResizable(false);
        ventana.show();
        
        cargarBarraDeMenu();

        crearPantallaInicio();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void cargarBarraDeMenu() {
    	this.menuBar = new MenuBar();

        Menu sonido = new Menu("Sonido");
        	Sonido musica = new Sonido();
            MenuItem activado = new MenuItem("Activado");
            activado.setOnAction(e -> {
            	musica.player.play();
            });
            MenuItem desactivado = new MenuItem("Desactivado");
            desactivado.setOnAction(e -> {
                musica.player.pause();
            });
        sonido.getItems().addAll(activado,desactivado);

        Menu salir = new Menu("Salir");
        salir.setOnAction(e -> {
        });

        menuBar.getMenus().addAll(sonido,salir);
    }
    
    public MenuBar barraDeMenu(){
    	return this.menuBar;
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

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO
    }





}
