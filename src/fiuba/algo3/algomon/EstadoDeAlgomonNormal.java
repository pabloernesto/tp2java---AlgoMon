package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

public class EstadoDeAlgomonNormal implements EstadoDeAlgomon {

    public EstadoDeAlgomonNormal() {
    }

    @Override
    public void turnoTerminado(AlgoMon algomon) {
    }

    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, AlgoMon enemigo) {
        ataqueNormal.atacar(enemigo);
        return this;
    }

    @Override
    public void causarDanio(int potencia, AlgoMon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, AlgoMon algoMon) {
       algoMon.estado(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

}
