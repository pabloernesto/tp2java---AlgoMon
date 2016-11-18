package fiuba.algo3.algomon.modelo;

public class EstadoDeAlgomonNormal implements EstadoDeAlgomon {

    public EstadoDeAlgomonNormal() {
    }

    @Override
    public void turnoTerminado(Algomon algomon) {
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void consecuencia(Algomon algomon) {
    }
}
