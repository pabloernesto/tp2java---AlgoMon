package fiuba.algo3.algomon.modelo;

import fiuba.algo3.algomon.test.Item;

public class SuperPocion extends Item {

    public void aplicar(Algomon algomonActivo) {
        algomonActivo.recuperarVida(40);
    }
}
