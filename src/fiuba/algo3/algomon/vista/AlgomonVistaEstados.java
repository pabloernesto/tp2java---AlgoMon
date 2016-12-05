package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.Observer;
import java.util.Observable;

public class AlgomonVistaEstados extends HBox implements Observer {

    Algomon algomon;

    public AlgomonVistaEstados(Algomon a) {
        algomon = a;
        a.addObserver(this);
        update(algomon, null);
    }

    public void update(Observable o, Object arg) {
        getChildren().clear();

        if (algomon.estaDormido())
            getChildren().add(new ImageView("images/status/dormido.png"));

        if (algomon.estaQuemado())
            getChildren().add(new ImageView("images/status/quemado.png"));
    }
}
