package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.ImageView;

public class AlgomonVista {

    Algomon algomon;

    public AlgomonVista(Algomon a) {
        algomon = a;
    }

    public ImageView imagenFrente() {

        String path = "file:resources/images/front"
            + algomon.nombreEspecie()
            + ".png";
        return new ImageView(path);
    }

    public ImageView imagenEspalda() {

        String path = "file:resources/images/back"
            + algomon.nombreEspecie()
            + ".png";
        return new ImageView(path);
    }
}
