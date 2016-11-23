package fiuba.algo3.algomon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;

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

	@Test
	public void cambiaElTurnoDespuesDeQueJugadorRealizaUnaAccion(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		juego.agregarJugador(new Jugador("Nahuel"));
		
		juego.jugador(0).elegirAlgomon(Especie.BULBASAUR.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		
		juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
		juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());
		juego.jugador(1).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());	
		
		int nroDeJugadorQueJuegaPrimero = juego.turno;
		
		juego.realizarAccion(juego.jugador(nroDeJugadorQueJuegaPrimero)).cambiarAlgomonActivo(1);
		// TODO pasa el test, pero no está buena la solución
		
		assertNotSame(juego.turno,nroDeJugadorQueJuegaPrimero);
	}

}
