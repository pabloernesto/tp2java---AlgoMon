package fiuba.algo3.algomon.modelo;

import java.util.EnumMap;
import java.util.Map;
import java.util.Observable;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;
import fiuba.algo3.algomon.excepciones.juegoTerminadoException;
import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.modelo.elementos.Pocion;
import fiuba.algo3.algomon.modelo.elementos.Restaurador;
import fiuba.algo3.algomon.modelo.elementos.SuperPocion;
import fiuba.algo3.algomon.modelo.elementos.Vitamina;
import fiuba.algo3.algomon.modelo.estado.EstadoDeAlgomon;
import fiuba.algo3.algomon.modelo.estado.EstadoDeAlgomonNormal;

public class Algomon extends Observable {

    private Tipo tipo;
    int vida;
    int vidaOriginal;
    EstadoDeAlgomon estadoEfimero = new EstadoDeAlgomonNormal();
    EstadoDeAlgomon estadoPermanente = new EstadoDeAlgomonNormal();
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);
    String nombreEspecie;

    public Algomon(String nombreEspecie, Tipo tipo, Movimiento [] movimientos,
        int vida) {

        this.nombreEspecie = nombreEspecie;

        this.setTipo(tipo);

        for (Movimiento m : movimientos) {
            Ataque a = m.nuevo();

            a.setAtacante(this);
            ataques.put(m, a);
        }

        this.vida = vida;
        this.vidaOriginal = vida;
    }

    public Algomon atacar(Algomon enemigo, Movimiento movimiento) {

        Ataque a = ataques.get(movimiento);
        if (a == null)
            throw new AlgomonNoPoseeElMovimientoException();

        estadoEfimero.consecuencia(this);
        estadoPermanente.consecuencia(this);
        a.efectuar(enemigo);
        return this;
    }

    public Ataque[] ataques() {
        return ataques.values().toArray(new Ataque[0]);
    }

    public int vidaOriginal() {
        return vidaOriginal;
    }

    public int vida() {
        return vida;
    }

    public void recuperarEstadoPermanente() {
        estadoPermanente = new EstadoDeAlgomonNormal();
        setChanged();
        notifyObservers("");
    }

    public void recuperarEstadoEfimero() {
        estadoEfimero = new EstadoDeAlgomonNormal();
        setChanged();
        notifyObservers("");
    }

    public void restaurarEstados() {
        this.recuperarEstadoEfimero();
        this.recuperarEstadoPermanente();
    }

    public void cambiarEstadoEfimero(EstadoDeAlgomon nuevoEstado) {
        estadoEfimero = nuevoEstado;
        setChanged();
        notifyObservers("");
    }

    public void cambiarEstadoPermanente(EstadoDeAlgomon nuevoEstado) {
        estadoPermanente = nuevoEstado;
        setChanged();
        notifyObservers("");
    }

    public Algomon turnoTerminado() {
        estadoEfimero.turnoTerminado(this);
        setChanged();
        notifyObservers("");
        return this;
    }

    public void causarDanio(int potencia)  throws juegoTerminadoException{
        vida -= potencia;
        if (vida <= 0){
            vida = 0;
            Juego juego = Juego.instancia();
            juego.reemplazarAlgomonDesmayado();
        }

        setChanged();
        notifyObservers("vida");
    }

    public void recuperarVida(int cantidad) {
        vida += cantidad;
        if (vida > vidaOriginal)
            vida = vidaOriginal;

        setChanged();
        notifyObservers("vida");
    }

    public String nombreEspecie() {
        return nombreEspecie;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void aplicar(Restaurador restaurador) {
        this.restaurarEstados();
        estadoPermanente.consecuencia(this);

    }

    public void aplicar(Pocion pocion) {
        this.recuperarVida(20);
        estadoPermanente.consecuencia(this);

    }

    public void aplicar(SuperPocion superPocion) {
        this.recuperarVida(40);
        estadoPermanente.consecuencia(this);

    }

    public void aplicar(Vitamina vitamina) {
        for (Ataque ataque : ataques.values() ){
            ataque.recuperarUsos(2);
        }
        estadoPermanente.consecuencia(this);
    }

//    public void pedirCambioSiEstaDesmayado(Jugador jugador) {
//        if(vida==0){jugador.cambiarAlgomonActivo();};
//
//    }

    public boolean puedePelear() {
        return (vida>0);
    }

    public boolean estaQuemado() {
        return estadoPermanente.estaQuemado();
    }

    public boolean estaDormido() {
        return estadoEfimero.estaDormido();
    }
}
