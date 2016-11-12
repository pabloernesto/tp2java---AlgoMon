package fiuba.algo3.algomon.test;

import org.junit.Test;

import fiuba.algo3.algomon.Juego;
import fiuba.algo3.algomon.Jugador;
import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;

public class JuegoTest {

	@Test (expected = ImposibleAgregarMasJugadoresException.class)
	public void jueganDosJugadores(){
		
		Juego juego = new Juego();
		
		juego.agregarJugador(0, new Jugador("Daniel"));
		juego.agregarJugador(1, new Jugador("Rocío"));
		juego.agregarJugador(2, new Jugador("Matías"));
		
	}
	
}
