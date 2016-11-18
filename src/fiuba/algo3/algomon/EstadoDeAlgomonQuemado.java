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
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, Algomon algoMon) {
       algoMon.cambiarEstadoPermanente(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

	public void consecuencia(Algomon algomon) {
		int vida = algomon.vidaOriginal();
        int potencia = vida / 10;
        algomon.causarDanio(potencia);
	}

}
