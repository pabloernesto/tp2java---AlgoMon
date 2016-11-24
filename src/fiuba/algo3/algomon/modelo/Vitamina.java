package fiuba.algo3.algomon.modelo;

public class Vitamina extends Item {

    Vitamina(Elemento unElemento) {
        super(unElemento.cantidadInicialDeElemento);
    }

    public void efecto(Algomon algomonActivo) {
        algomonActivo.tomarVitamina();
    }
}
