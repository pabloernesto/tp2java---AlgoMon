package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CantoTest
{
    @Before
    public void setUp() {
        Juego.borrarInstancia();
    }

    @Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeCharmander()
    {
        Juego juego = Juego.instancia();

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
        Juego juego = Juego.instancia();

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
        Juego juego = Juego.instancia();

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

    @Test 
    public void cantoNoCambiaElEstadoLuegoAgotarSusUsos()
    {
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();
        Algomon rattata1 = Especie.RATTATA.nuevo();
        Algomon rattata2 = Especie.RATTATA.nuevo();

        try{
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata2, Movimiento.CANTO);}
        catch (Exception e) {
            rattata2.atacar(jigglypuff, Movimiento.ATAQUE_RAPIDO);
        }
    }

}
