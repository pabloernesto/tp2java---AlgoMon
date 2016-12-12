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

        juego.getJugadorNro(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(0).algomonNro(1).atacar(juego.getJugadorNro(1).algomonNro(2), Movimiento.CANTO);
        juego.getJugadorNro(1).algomonNro(2).atacar(juego.getJugadorNro(0).algomonNro(2), Movimiento.BRASAS);

    }

    @Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeRattataPorTresTurnos()
    {
        Juego juego = Juego.instancia();

        juego.agregarJugador(new Jugador("Natalia"));
        juego.agregarJugador(new Jugador("Nahuel"));

        juego.getJugadorNro(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(0).algomonNro(2).atacar(juego.getJugadorNro(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0

        juego.getJugadorNro(1).algomonNro(3).atacar(juego.getJugadorNro(0).algomonNro(2), Movimiento.BURBUJA);
    }

    @Test
    public void rattataPuedeAtacarElCuartoTurnoDespuesDeQueLeHagaCanto()
    {
        Juego juego = Juego.instancia();

        juego.agregarJugador(new Jugador("Natalia"));
        juego.agregarJugador(new Jugador("Nahuel"));

        juego.getJugadorNro(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
        juego.getJugadorNro(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.getJugadorNro(1).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.getJugadorNro(0).algomonNro(2).atacar(juego.getJugadorNro(1).algomonNro(3), Movimiento.CANTO);
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0
        juego.pasarTurno();     // Turno jugador 1
        juego.pasarTurno();     // Turno jugador 0

        juego.getJugadorNro(1).algomonNro(3).atacar(juego.getJugadorNro(0).algomonNro(2), Movimiento.BURBUJA);

        assertEquals(juego.getJugadorNro(0).algomonNro(2).getVida(), 120);
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
        catch (CantidadDeAtaquesExcedidaException e) {
            //si rattata2 es afectador por canto, el metodo atacar tiraria una excepcion y el test fallaria
            rattata2.atacar(jigglypuff, Movimiento.ATAQUE_RAPIDO);
        }
    }

}
