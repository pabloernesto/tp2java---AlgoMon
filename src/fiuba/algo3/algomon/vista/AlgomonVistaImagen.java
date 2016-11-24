package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlgomonVistaImagen extends ImageView {

    Algomon algomon;

    public AlgomonVistaImagen(Algomon a) {
        algomon = a;
        mostrarFrente();
    }

    public ImageView mostrarFrente() {
        setImage(new Image(imagenFrentePath()));
        return this;
    }

    public ImageView mostrarEspalda() {
        setImage(new Image(imagenEspaldaPath()));
        return this;
    }

    String imagenFrentePath() {
        String path = "images/front/"
            + algomon.nombreEspecie()
            + ".png";
        return path;
    }

    String imagenEspaldaPath() {
        String path = "images/back/"
            + algomon.nombreEspecie()
            + ".png";
        return path;
    }
}
