package fiuba.algo3.algomon.modelo.estado;

import fiuba.algo3.algomon.modelo.Algomon;

public class EstadoDeAlgomonQuemado implements EstadoDeAlgomon {

    public EstadoDeAlgomonQuemado() {
    }

    @Override
    public void turnoTerminado(Algomon algomon) {
        int vida = algomon.vidaOriginal();
        int potencia = vida / 10;
        algomon.causarDanio(potencia);
    }

    public void consecuencia(Algomon algomon) {
        int vida = algomon.vidaOriginal();
        int potencia = vida / 10;
        algomon.causarDanio(potencia);
    }

    public boolean estaQuemado() {
        return true;
    }

    public boolean estaDormido() {
        return false;
    }
}
