package fiuba.algo3.algomon;

public class AtaqueFogonazo extends Ataque {

    public AtaqueFogonazo(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {
        atacado.cambiarEstadoPermanente(new EstadoDeAlgomonQuemado());

        int danio;
        danio = super.efectuar(atacado);
        return danio;
    }
}
