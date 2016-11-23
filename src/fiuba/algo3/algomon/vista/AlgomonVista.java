package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.util.Observer;
import java.util.Observable;

public class AlgomonVista {

    Algomon algomon;

    public AlgomonVista(Algomon a) {
        algomon = a;
    }

    public ImageView imagenFrente() {

        String path = "resources/images/front"
            + algomon.nombreEspecie()
            + ".png";
        return new ImageView(path);
    }

    public ImageView imagenEspalda() {

        String path = "resources/images/back"
            + algomon.nombreEspecie()
            + ".png";
        return new ImageView(path);
    }

    public ProgressBar barraDeVida() {
        BarraDeVida b = new BarraDeVida();
        algomon.addObserver(b);
        return b;
    }
}

class BarraDeVida extends ProgressBar implements Observer {

    public void update(Observable o, Object arg) {
        Algomon a = (Algomon) o;
        String attribute = (String) arg;

        if (attribute.equals("vida")) {
            double v = (double) a.vida();
            double vo = (double) a.vidaOriginal();
            setProgress(v / vo);
        }
    }
}
