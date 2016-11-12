package fiuba.algo3.algomon;

import java.util.ArrayList;

public class Juego {

	public ArrayList<Jugador> jugadores;
	public int turno;

	public Juego(){
		this.jugadores = new ArrayList<Jugador>();
		this.turno = 0;
	}
	
	public void agregarJugador(int nroDeJugador, Jugador jugador) {
		jugadores.add(nroDeJugador, jugador);
	}

	public int pasarTurno() {
		if (turno == 0) 
			return 1;
		else 
			return 0;
	}

	public Jugador turno() {
		return jugadores.get(turno);
	}

	public Jugador jugador(int nroDeJugador) {
		return jugadores.get(nroDeJugador);
	}

}
