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
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataque, Algomon algoMon) {
       algoMon.cambiarEstadoEfimero(ataque.estadoDelAlgomonAtacante(ataque));
    }

	@Override
	public void consecuencia(Algomon algomon) {
	}

}
