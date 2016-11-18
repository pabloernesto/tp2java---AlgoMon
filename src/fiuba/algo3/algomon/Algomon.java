package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class Algomon {

    Tipo tipo;
    int vida;
    private int vidaOriginal;
    EstadoDeAlgomon estadoEfimero = new EstadoDeAlgomonNormal();
    EstadoDeAlgomon estadoPermanente = new EstadoDeAlgomonNormal();
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);

    public Algomon(Tipo tipo, Movimiento [] movimientos, int vida) {

        this.tipo = tipo;

        for (Movimiento m : movimientos) {
            Ataque a = m.nuevo();

            a.setAtacante(this);
            ataques.put(m, a);
        }

        this.vida = vida;
        this.vidaOriginal = vida;

    }

    public Algomon atacar(Algomon enemigo, Movimiento movimiento) {
        try{
            estadoEfimero.consecuencia(this);
            estadoPermanente.consecuencia(this);

            ataques.get(movimiento).efectuar(enemigo);

            return this;
        }
        catch(NullPointerException e){throw new AlgomonNoPoseeElMovimientoException();}
    }

    public int vidaOriginal() {
        return this.vidaOriginal;
    }

    public int vida() {
        return vida;
    }

    public void recuperarEstadoEfimero() {
       this.estadoEfimero = new EstadoDeAlgomonNormal();
    }

    public void cambiarEstadoEfimero(EstadoDeAlgomon nuevoEstado) {
        this.estadoEfimero = nuevoEstado;
    }

    public void cambiarEstadoPermanente(EstadoDeAlgomon nuevoEstado) {
        this.estadoPermanente = nuevoEstado;
    }

    public Algomon turnoTerminado() {
        estadoEfimero.turnoTerminado(this);
        return this;
    }

    public void causarDanio(int potencia) {
        this.estadoEfimero.causarDanio(potencia, this);
    }

    public void recuperarVida(int cantidad) {
        vida += cantidad;
        //~ if (vida > vidaOriginal)
            //~ vida = vidaOriginal;
    }
}
