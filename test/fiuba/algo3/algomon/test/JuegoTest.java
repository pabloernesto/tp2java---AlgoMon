package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.Juego;
import fiuba.algo3.algomon.Jugador;
import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;

public class JuegoTest {

	@Test (expected = ImposibleAgregarMasJugadoresException.class)
	public void jueganMaximoDosJugadores(){
		
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Otto"));
		juego.agregarJugador(new Jugador("Mabel"));
		juego.agregarJugador(new Jugador("Cristina"));
		
	}
	
	@Test
	public void sistemaDeTurnos(){
		
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		juego.agregarJugador(new Jugador("Otto"));
		
		String jugadorQueEmpieza = juego.turno().getNombre();
		juego.pasarTurno();
		juego.pasarTurno();
		
		assertEquals(jugadorQueEmpieza,juego.turno().getNombre());
	}
	
}
