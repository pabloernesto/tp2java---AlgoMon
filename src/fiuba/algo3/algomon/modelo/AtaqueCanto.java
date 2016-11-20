package fiuba.algo3.algomon.modelo;

public class AtaqueCanto extends Ataque {

    public AtaqueCanto(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {

        atacado.cambiarEstadoEfimero(new EstadoDeAlgomonDormido());
        return super.efectuar(atacado);
    }
}
