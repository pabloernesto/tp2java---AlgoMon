package fiuba.algo3.algomon.modelo.ataque;

import fiuba.algo3.algomon.excepciones.juegoTerminadoException;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Movimiento;
import fiuba.algo3.algomon.modelo.estado.EstadoDeAlgomonQuemado;

public class AtaqueFogonazo extends Ataque {

    public AtaqueFogonazo(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) throws juegoTerminadoException {
        int cantidadDeDanioCausado = super.efectuar(atacado);
        atacado.cambiarEstadoPermanenteA(new EstadoDeAlgomonQuemado());
        return cantidadDeDanioCausado;
    }
}
