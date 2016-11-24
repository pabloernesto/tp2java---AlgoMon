package fiuba.algo3.algomon.modelo;

import fiuba.algo3.algomon.excepciones.CantidadElementosExcedidaException;

abstract class Item {
    int cantidadDeUsosRestantes;
    Item(int cantidadDeElementos){
        this.cantidadDeUsosRestantes = cantidadDeElementos;
    };

    public void aplicar(Algomon algomonActivo) {
        if (cantidadDeUsosRestantes == 0)
            throw new CantidadElementosExcedidaException();
        cantidadDeUsosRestantes--;
        this.efecto(algomonActivo);
    }

    abstract void efecto(Algomon unAlgomon);
}
