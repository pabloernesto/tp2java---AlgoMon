package fiuba.algo3.algomon;

import java.util.ArrayList;

import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;

public class Juego {

	public ArrayList<Jugador> jugadores;
	public int turno;

	public Juego(){
		this.jugadores = new ArrayList<Jugador>();
		this.turno = 0;
	}
	
	//refactor -> quitar nroDeJugador
	public void agregarJugador(int nroDeJugador, Jugador jugador) {
		
		switch (this.jugadores.size()){
			case 0 : 	this.jugadores.add(jugador);
						break;
			case 1 :	this.jugadores.add(1, jugador);
						break;
			default: 	throw new ImposibleAgregarMasJugadoresException();
		}
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
