package fiuba.algo3.algomon.modelo;

public class AtaqueFogonazo extends Ataque {

    public AtaqueFogonazo(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {

        atacado.cambiarEstadoPermanente(new EstadoDeAlgomonQuemado());
        return super.efectuar(atacado);
    }
}
