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
            algomon.recuperarEstadoEfimero();
        }
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;

    }

    @Override
    public void consecuencia(Algomon algomon) {
        throw new AlgomonEstaInhabilitadoParaAtacarException();
    }
}
