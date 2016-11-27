package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.modelo.Algomon;

public class SuperPocion extends Item {

    SuperPocion(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.recuperarVida(40);
    }
}
