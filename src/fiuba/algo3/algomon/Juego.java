package fiuba.algo3.algomon;

import java.util.ArrayList;
import java.util.Random;
import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;

public class Juego {

	public ArrayList<Jugador> jugadores;
	public int turno;

	public Juego(){
		this.jugadores = new ArrayList<Jugador>();
		this.turno = new Random().nextInt(2);
	}

	public Jugador jugador(int nroDeJugador) {
		return this.jugadores.get(nroDeJugador);
	}
	
	public void agregarJugador(Jugador jugador) {
		
		switch (this.jugadores.size()){
			case 0 : 	this.jugadores.add(jugador);
						break;
			case 1 :	this.jugadores.add(1, jugador);
						break;
			default: 	throw new ImposibleAgregarMasJugadoresException();
		}
	}

	public Jugador turno() {
		return this.jugadores.get(turno);
	}
	
	public void pasarTurno() {
		
		this.jugador(this.turno).actualizarEstadoAlgomones();
		this.cambiarTurno();
		
	}

	private void cambiarTurno() {
		if (this.turno == 0) 
			this.turno = 1;
		else 
			this.turno = 0;
	}


}
