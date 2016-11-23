package fiuba.algo3.algomon.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;

public class JugadorTest {

	@Test (expected = ImposibleElegirMasDeTresAlgomonesException.class)
	public void MaximoTresAlgomonesPorJugador(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		juego.jugador(0).elegirAlgomon(Especie.BULBASAUR.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.SQUIRTLE.nuevo());
		
	}

	@Test
	public void primerAlgomonElegidoPorJugadorEsAlgomonActivoPorDefecto(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		Algomon primerAlgomon = Especie.BULBASAUR.nuevo();
		
		juego.jugador(0).elegirAlgomon(primerAlgomon);
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		
		assertEquals(juego.jugador(0).getAlgomonActivo(), primerAlgomon);		
	}

}
