package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.Especie;
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
		
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());
    	
    	juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());
		
		String jugadorQueEmpieza = juego.turno().nombre();
		juego.pasarTurno();
		juego.pasarTurno();
		
		assertEquals(jugadorQueEmpieza,juego.turno().nombre());
	}
	
}
