package fiuba.algo3.algomon;

import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;

public class EstadoDeAlgomonDormido implements EstadoDeAlgomon {

    int turnosRestantesDormido;

    public EstadoDeAlgomonDormido() {
        super();
        this.turnosRestantesDormido = 3;
    }

    @Override
    public void turnoTerminado(Algomon algomon) {
        turnosRestantesDormido -= 1;
        if(turnosRestantesDormido ==0 ){
            algomon.recuperarEstado();
        }
    }

    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo) throws AlgomonEstaInhabilitadoParaAtacarException {
       throw new AlgomonEstaInhabilitadoParaAtacarException();
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;

    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, Algomon algoMon) {
    }

}
