package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;

//~ es un singleton
public class Juego implements Observer {

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

    public Jugador jugador(int nroDeJugador) {
        return this.jugadores.get(nroDeJugador);
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() > 1)
            throw new ImposibleAgregarMasJugadoresException();
        jugadores.add(jugador);
        jugador.addObserver(this);
    }

    public Jugador turno() {
        return this.jugadores.get(turno);
    }

    public void pasarTurno() {
        jugador(this.turno).terminarTurno();
        this.cambiarTurno();

    }

    private void cambiarTurno() {
        if (this.turno == 0)
            this.turno = 1;
        else
            this.turno = 0;
    }

    @Override
    public void update(Observable jugador, Object arg) {
        this.pasarTurno();
    }
}
