package fiuba.algo3.algomon.modelo.elementos;

import fiuba.algo3.algomon.modelo.Algomon;

public abstract class Item {
    int cantidadDeUsosRestantes;
    private Elemento elemento;
    public Item(){};

    public Item(Elemento unElemento) {
        this.cantidadDeUsosRestantes = unElemento.cantidadInicialDeElemento;
        this.elemento = unElemento;
    }

    public abstract void aplicar(Algomon algomonActivo);

    public String getNombreParaMostrar(){
    	return elemento.getNombre() + " (" + cantidadDeUsosRestantes + "/" + elemento.cantidadInicialDeElemento + ")";
    };

    public Elemento elemento(){
        return this.elemento;
    };
    public int usosRestantes() {
        return cantidadDeUsosRestantes;
    }
}
