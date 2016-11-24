package fiuba.algo3.algomon.modelo;

public class Pocion extends Item {

    Pocion(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.recuperarVida(20);
    }
    
}
