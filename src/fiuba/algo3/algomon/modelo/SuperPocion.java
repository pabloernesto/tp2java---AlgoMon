package fiuba.algo3.algomon.modelo;

public class SuperPocion extends Item {

    public void aplicar(Algomon algomonActivo) {
        algomonActivo.recuperarVida(40);
    }
}
