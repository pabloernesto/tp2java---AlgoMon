package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

public class EstadoDeAlgomonNormal implements EstadoDeAlgomon {

    public EstadoDeAlgomonNormal() {
    }

    @Override
    public void turnoTerminado(Algomon algomon) {
    }

    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo) {
        ataqueNormal.atacar(enemigo);
        return this;
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, Algomon algoMon) {
       algoMon.estado(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

}
