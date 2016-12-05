package fiuba.algo3.algomon.modelo.estado;

import fiuba.algo3.algomon.modelo.Algomon;

public interface EstadoDeAlgomon {

    public void turnoTerminado(Algomon algoMon);
    public void consecuencia(Algomon algomon);
    public boolean estaQuemado();
    public boolean estaDormido();
}
