package fiuba.algo3.algomon;

public class AtaqueCanto extends Ataque {

    public AtaqueCanto(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {
        atacado.estado(new EstadoDeAlgomonDormido());

        int danio;
        danio = super.efectuar(atacado);
        return danio;
    }
}
