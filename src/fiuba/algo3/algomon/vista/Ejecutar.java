package fiuba.algo3.algomon.vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class Ejecutar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      stage.setScene(new EscenaPrincipal(stage));
      stage.setTitle("Algomon 2.0 BETA Version");
      stage.show();

    }


}
