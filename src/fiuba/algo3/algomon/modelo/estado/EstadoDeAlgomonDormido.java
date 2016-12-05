package fiuba.algo3.algomon.modelo.estado;

import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;
import fiuba.algo3.algomon.modelo.Algomon;

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
    public void consecuencia(Algomon algomon) {
        throw new AlgomonEstaInhabilitadoParaAtacarException();
    }

    public boolean estaQuemado() {
        return false;
    }

    public boolean estaDormido() {
        return true;
    }
}
