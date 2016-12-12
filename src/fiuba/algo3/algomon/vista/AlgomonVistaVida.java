package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.control.ProgressBar;
import java.util.Observer;
import java.util.Observable;

public class AlgomonVistaVida extends ProgressBar implements Observer {

    public AlgomonVistaVida() {
    }

    public AlgomonVistaVida(Algomon algomon) {
        algomon.addObserver(this);
        update(algomon, "vida");
    }

    public void update(Observable o, Object arg) {
        Algomon a = (Algomon) o;
        String attribute = (String) arg;

        if (attribute.equals("vida")) {
            double v = (double) a.getVida();
            double vo = (double) a.getVidaOriginal();
            setProgress(v / vo);
        }
    }
}
