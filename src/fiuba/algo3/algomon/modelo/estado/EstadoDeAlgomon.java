package fiuba.algo3.algomon.modelo.estado;

import fiuba.algo3.algomon.excepciones.juegoTerminadoException;
import fiuba.algo3.algomon.modelo.Algomon;

public interface EstadoDeAlgomon {

    public void turnoTerminado(Algomon algoMon) throws juegoTerminadoException;
    public void consecuencia(Algomon algomon) throws juegoTerminadoException;
    public boolean estaQuemado();
    public boolean estaDormido();
}
