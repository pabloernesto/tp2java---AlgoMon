package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;
import fiuba.algo3.algomon.excepciones.juegoTerminadoException;

public class Juego extends Observable implements Observer {

    static Juego instancia;

    ArrayList<Jugador> jugadores;
    int turno;

    public static Juego instancia() {
        if (instancia == null)
            instancia = new Juego();

        return instancia;
    }

    public static void borrarInstancia() {
        instancia = null;
    }

    Juego(){
        this.jugadores = new ArrayList<Jugador>();
        this.turno = new Random().nextInt(2);
    }

    public Jugador getJugadorNro(int nroDeJugador) {
        return this.jugadores.get(nroDeJugador);
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() > 1)
            throw new ImposibleAgregarMasJugadoresException();
        jugadores.add(jugador);
        jugador.addObserver(this);
    }

    public Jugador obtenerJugadorActivo() {
        return this.jugadores.get(turno);
    }

    public Jugador obtenerJugadorNoActivo(){
        int turnoAux;
        if (this.turno == 0) turnoAux = 1; else turnoAux = 0;
        return jugadores.get(turnoAux);
    }

    public void pasarTurno() {
        getJugadorNro(this.turno).actualizarEstadoDeAlgomonesPorPasoDeTurno();
        this.cambiarJugadorQueJuega();

        setChanged();
        notifyObservers();
    }

    private void cambiarJugadorQueJuega() {
        if (this.turno == 0)
            this.turno = 1;
        else
            this.turno = 0;
    }

    public void reemplazarAlgomonDesmayado()  throws juegoTerminadoException{
        for  (Jugador jugador : jugadores){
            jugador.reemplazarAlgomonSiEstaDesmayado();
        }
    }

    public boolean jugadorActivoPuedeContinuar() {
        return this.obtenerJugadorActivo().quedanAlgomonesConscientes();
    }

    @Override
    public void update(Observable jugador, Object arg) {
        this.pasarTurno();
    }
}
