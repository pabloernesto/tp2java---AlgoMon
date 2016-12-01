package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.modelo.Algomon;

public abstract class Item {
    int cantidadDeUsosRestantes;

    public abstract void aplicar(Algomon algomonActivo);

    public abstract String nombre();

    public int usosRestantes() {
        return cantidadDeUsosRestantes;
    }
}
