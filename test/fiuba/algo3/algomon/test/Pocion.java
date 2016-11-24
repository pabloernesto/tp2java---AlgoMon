package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.modelo.Algomon;

public class Pocion extends Item {

    public void aplicar(Algomon algomonActivo) {
        algomonActivo.recuperarVida(20);
    }
    
}
