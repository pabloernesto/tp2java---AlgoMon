package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

public class EstadoDeAlgomonQuemado implements EstadoDeAlgomon {

    Map<Movimiento, AtaqueNormal> ataques = new EnumMap<Movimiento, AtaqueNormal>(Movimiento.class);

    public EstadoDeAlgomonQuemado() {
    }

    @Override
    public void turnoTerminado(AlgoMon algomon) {
        int vida = algomon.vidaOriginal();
        int potencia = vida / 10;
        algomon.causarDanio(potencia);
    }

    @Override
    public EstadoDeAlgomon atacar(AtaqueNormal ataqueNormal, AlgoMon enemigo) {
        ataqueNormal.atacar(enemigo);
        return this;
    }

    @Override
    public void causarDanio(int potencia, AlgoMon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(AtaqueNormal ataqueNormal, AlgoMon algoMon) {
       algoMon.estado(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

}
