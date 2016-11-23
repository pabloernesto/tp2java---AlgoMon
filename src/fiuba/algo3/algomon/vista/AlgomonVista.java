package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.ImageView;

public class AlgomonVista {

    Algomon algomon;

    public AlgomonVista(Algomon a) {
        algomon = a;
    }

    public ImageView imagen() {

        String path = "file:src/fiuba/algo3/algomon/vista/imagenes/"
            + algomon.nombreEspecie()
            + ".jpg";
        return new ImageView(path);
    }
}
