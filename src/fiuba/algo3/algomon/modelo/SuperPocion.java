package fiuba.algo3.algomon.modelo;

public class SuperPocion extends Item {

    SuperPocion(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.recuperarVida(40);
    }
}
