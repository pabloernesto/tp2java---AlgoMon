package fiuba.algo3.algomon.modelo;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;
import java.util.Observable;

public class Algomon extends Observable {

    Tipo tipo;
    int vida;
    int vidaOriginal;
    EstadoDeAlgomon estadoEfimero = new EstadoDeAlgomonNormal();
    EstadoDeAlgomon estadoPermanente = new EstadoDeAlgomonNormal();
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);
    String nombreEspecie;

    public Algomon(String nombreEspecie, Tipo tipo, Movimiento [] movimientos,
        int vida) {

        this.nombreEspecie = nombreEspecie;

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
        try {
            estadoEfimero.consecuencia(this);
            estadoPermanente.consecuencia(this);

            ataques.get(movimiento).efectuar(enemigo);

            return this;
        }
        catch (NullPointerException e) {
            throw new AlgomonNoPoseeElMovimientoException();
        }
    }

    public int vidaOriginal() {
        return vidaOriginal;
    }

    public int vida() {
        return vida;
    }

    public void recuperarEstadoPermanente() {
       estadoPermanente = new EstadoDeAlgomonNormal();
    }

    public void recuperarEstadoEfimero() {
       estadoEfimero = new EstadoDeAlgomonNormal();
    }

    public void restaurarEstados() {
        this.recuperarEstadoEfimero();
        this.recuperarEstadoPermanente();
    }

    public void cambiarEstadoEfimero(EstadoDeAlgomon nuevoEstado) {
        estadoEfimero = nuevoEstado;
    }

    public void cambiarEstadoPermanente(EstadoDeAlgomon nuevoEstado) {
        estadoPermanente = nuevoEstado;
    }

    public Algomon turnoTerminado() {
        estadoEfimero.turnoTerminado(this);
        return this;
    }

    public void causarDanio(int potencia) {
        vida -= potencia;
        if (vida < 0)
            vida = 0;

        setChanged();
        notifyObservers();
    }

    public void recuperarVida(int cantidad) {
        vida += cantidad;
        if (vida > vidaOriginal)
            vida = vidaOriginal;

        setChanged();
        notifyObservers();
    }

    public String nombreEspecie() {
        return nombreEspecie;
    }

    public void tomarVitamina() {
       for (Ataque ataque : ataques.values() ){
           ataque.recuperarUsos(2);
       }
    }
}
