package fiuba.algo3.algomon;

import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;

public class EstadoDeAlgomonDormido implements EstadoDeAlgomon {

    int turnosRestantesDormido;

    public EstadoDeAlgomonDormido() {
        super();
        this.turnosRestantesDormido = 3;
    }

    @Override
    public void turnoTerminado(AlgoMon algomon) {
        turnosRestantesDormido -= 1;
        if(turnosRestantesDormido ==0 ){
            algomon.recuperarEstado();
        }
    }

    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, AlgoMon enemigo) throws AlgomonEstaInhabilitadoParaAtacarException {
       throw new AlgomonEstaInhabilitadoParaAtacarException();
    }

    @Override
    public void causarDanio(int potencia, AlgoMon algoMon) {
        algoMon.vida -= potencia;

    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, AlgoMon algoMon) {
    }

}
