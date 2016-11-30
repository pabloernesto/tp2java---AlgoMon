package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.excepciones.CantidadElementosExcedidaException;
import fiuba.algo3.algomon.modelo.Algomon;

public class Pocion implements Item {

    int cantidadDeUsosRestantes;
    Pocion(Elemento unElemento) {
        this.cantidadDeUsosRestantes = unElemento.cantidadInicialDeElemento;
    };

    public void aplicar(Algomon algomonActivo) {
        if (cantidadDeUsosRestantes == 0)
            throw new CantidadElementosExcedidaException();
        cantidadDeUsosRestantes--;
        algomonActivo.aplicar(this);
    }

}
