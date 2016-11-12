package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.Especie;
import fiuba.algo3.algomon.Juego;
import fiuba.algo3.algomon.Jugador;
import fiuba.algo3.algomon.Movimiento;
import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;

public class JigglypuffTest {

	@Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeRattataPorTresTurnos()
    {
    	Juego juego = new Juego();
    	
    	juego.agregarJugador(new Jugador("Natalia"));
    	juego.agregarJugador(new Jugador("Martín"));
    	
    	juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());
    	
    	juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());
    	
        juego.jugador(0).algomonNro(2).atacar(juego.jugador(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno(); 	// Turno jugador 1
        juego.pasarTurno(); 	// Turno jugador 0
        juego.pasarTurno(); 	// Turno jugador 1
        juego.pasarTurno(); 	// Turno jugador 0

        juego.jugador(1).algomonNro(3).atacar(juego.jugador(0).algomonNro(2), Movimiento.BURBUJA);
    }
	
	@Test
    public void rattataPuedeAtacarElCuartoTurnoDespuesDeQueLeHagaCanto()
    {
    	Juego juego = new Juego();
    	
    	juego.agregarJugador(new Jugador("Natalia"));
    	juego.agregarJugador(new Jugador("Martín"));
    	
    	juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
    	juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());
    	
    	juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
    	juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());
    	
        juego.jugador(0).algomonNro(2).atacar(juego.jugador(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno(); 	// Turno jugador 1
        juego.pasarTurno(); 	// Turno jugador 0
        juego.pasarTurno(); 	// Turno jugador 1
        juego.pasarTurno(); 	// Turno jugador 0
        juego.pasarTurno(); 	// Turno jugador 1
        juego.pasarTurno(); 	// Turno jugador 0
        
        juego.jugador(1).algomonNro(3).atacar(juego.jugador(0).algomonNro(2), Movimiento.BURBUJA);
        
        assertEquals(juego.jugador(0).algomonNro(2).vida(), 120);
    }
}
