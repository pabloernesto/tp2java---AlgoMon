package fiuba.algo3.algomon.modelo.ataque;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Movimiento;
import fiuba.algo3.algomon.modelo.estado.EstadoDeAlgomonDormido;

public class AtaqueCanto extends Ataque {

    public AtaqueCanto(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {
        int cantidadDeDanioCausado = super.efectuar(atacado);
        atacado.cambiarEstadoEfimero(new EstadoDeAlgomonDormido());
        return cantidadDeDanioCausado;
    }
}