package fiuba.algo3.algomon.modelo;

public class Restaurador extends Item {

    Restaurador(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.restaurarEstados();
    }
}
