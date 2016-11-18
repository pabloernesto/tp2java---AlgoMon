package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

public class EstadoDeAlgomonQuemado implements EstadoDeAlgomon {

    public EstadoDeAlgomonQuemado() {
    }

    @Override
    public void turnoTerminado(Algomon algomon) {
        int vida = algomon.vidaOriginal();
        int potencia = vida / 10;
        algomon.causarDanio(potencia);
    }

    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo) {
        ataqueNormal.efectuar(enemigo);
        return this;
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }
}
