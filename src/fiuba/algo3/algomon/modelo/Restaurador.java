package fiuba.algo3.algomon.modelo;

public class Restaurador extends Item {

    public void aplicar(Algomon algomonActivo) {
        algomonActivo.restaurarEstados();
    }
}
