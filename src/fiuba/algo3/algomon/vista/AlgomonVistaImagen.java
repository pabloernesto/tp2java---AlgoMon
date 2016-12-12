package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlgomonVistaImagen extends ImageView {

    Algomon algomon;

    public AlgomonVistaImagen(Algomon a) {
        algomon = a;
    }

    public AlgomonVistaImagen mostrarFrente() {
        setImage(new Image(imagenFrentePath()));
        return this;
    }

    public AlgomonVistaImagen mostrarEspalda() {
        setImage(new Image(imagenEspaldaPath()));
        return this;
    }

    String imagenFrentePath() {
        String path = "images/front/"
            + nombreImagen()
            + ".png";
        return path;
    }

    String imagenEspaldaPath() {
        String path = "images/back/"
            + nombreImagen()
            + ".png";
        return path;
    }

    String nombreImagen() {
        String n = algomon.getNombreEspecie();
        return n.substring(0, 1) + n.substring(1).toLowerCase();
    }
}
