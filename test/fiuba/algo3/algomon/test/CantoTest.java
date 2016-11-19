package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import static org.junit.Assert.*;

public class CantoTest
{
    @Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeCharmander()
    {
        Juego juego = new Juego();

        juego.agregarJugador(new Jugador("Nahuel"));
        juego.agregarJugador(new Jugador("Juan"));

        juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(0).algomonNro(1).atacar(juego.jugador(1).algomonNro(2), Movimiento.CANTO);
        juego.jugador(1).algomonNro(2).atacar(juego.jugador(0).algomonNro(2), Movimiento.BRASAS);

    }

    @Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeRattataPorTresTurnos()
    {
        Juego juego = new Juego();

        juego.agregarJugador(new Jugador("Natalia"));
        juego.agregarJugador(new Jugador("Nahuel"));

        juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(0).algomonNro(2).atacar(juego.jugador(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0

        juego.jugador(1).algomonNro(3).atacar(juego.jugador(0).algomonNro(2), Movimiento.BURBUJA);
    }

    @Test
    public void rattataPuedeAtacarElCuartoTurnoDespuesDeQueLeHagaCanto()
    {
        Juego juego = new Juego();

        juego.agregarJugador(new Jugador("Natalia"));
        juego.agregarJugador(new Jugador("Nahuel"));

        juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(0).algomonNro(2).atacar(juego.jugador(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0

        juego.jugador(1).algomonNro(3).atacar(juego.jugador(0).algomonNro(2), Movimiento.BURBUJA);

        assertEquals(juego.jugador(0).algomonNro(2).vida(), 120);
    }
}
