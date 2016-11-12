package fiuba.algo3.algomon.test;

import org.junit.Test;

import fiuba.algo3.algomon.Especie;
import fiuba.algo3.algomon.Juego;
import fiuba.algo3.algomon.Jugador;
import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;

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
}
