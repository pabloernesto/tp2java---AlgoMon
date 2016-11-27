package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.modelo.Algomon;

public class Restaurador extends Item {

    Restaurador(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.restaurarEstados();
    }
}
