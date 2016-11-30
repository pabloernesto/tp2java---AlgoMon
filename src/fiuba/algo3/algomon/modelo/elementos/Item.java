package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.excepciones.CantidadElementosExcedidaException;
import fiuba.algo3.algomon.modelo.Algomon;

public interface Item {
    public void aplicar(Algomon algomonActivo);
}
