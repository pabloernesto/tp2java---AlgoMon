package fiuba.algo3.algomon.modelo;

public class Pocion extends Item {

    public void aplicar(Algomon algomonActivo) {
        algomonActivo.recuperarVida(20);
    }
    
}
