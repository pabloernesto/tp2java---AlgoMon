package fiuba.algo3.algomon.vista;

import java.io.IOException;

import fiuba.algo3.algomon.control.PrimeraPantallaControlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.URL;

public class Ejecutar extends Application {

    private Stage stagePrincipal;
    private BorderPane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        this.mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() throws IOException {

        FXMLLoader loader;

        {
            URL pantallaURL =
                Ejecutar.class.getResource("xml/PrimeraPantalla.fxml");
            loader = new FXMLLoader(pantallaURL);
        }

        loader.setController(new PrimeraPantallaControlador());
        this.rootPane = (BorderPane) loader.load();

        Scene escena = new Scene(rootPane,300,275,Color.BLUE);
        stagePrincipal.setTitle("Algomong 1.0 BETA Version");
        stagePrincipal.setScene(escena);

        PrimeraPantallaControlador controlador = loader.getController();
        controlador.setProgramaPrincipal(this);

        stagePrincipal.show();
    }


}
