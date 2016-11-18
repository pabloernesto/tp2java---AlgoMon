package fiuba.algo3.algomon;

public class AtaqueChupavidas extends Ataque {

    Algomon atacante;

    public AtaqueChupavidas(Movimiento m) {
        super(m);
    }

    public int efectuar(Algomon atacado) {
        int danio;
        danio = super.efectuar(atacado);

        atacante.recuperarVida(danio * 30 / 100);

        return danio;
    }

    public void setAtacante(Algomon atacante) {
        this.atacante = atacante;
    }
}
