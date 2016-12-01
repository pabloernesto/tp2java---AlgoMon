package fiuba.algo3.algomon.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import fiuba.algo3.algomon.excepciones.ImposibleAgregarMasJugadoresException;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.elementos.Elemento;

public class JuegoTest {

    @Before
    public void setUp() {
        Juego.borrarInstancia();
    }

    @Test (expected = ImposibleAgregarMasJugadoresException.class)
    public void jueganMaximoDosJugadores(){

        Juego juego = Juego.instancia();

        juego.agregarJugador(new Jugador("Otto"));
        juego.agregarJugador(new Jugador("Mabel"));
        juego.agregarJugador(new Jugador("Cristina"));

    }

    @Test
    public void sistemaDeTurnos(){

        Juego juego = Juego.instancia();

        juego.agregarJugador(new Jugador("Mabel"));
        juego.agregarJugador(new Jugador("Otto"));

        juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
        juego.jugador(0).elegirAlgomon(Especie.RATTATA.nuevo());

        juego.jugador(1).elegirAlgomon(Especie.CHANSEY.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.CHARMANDER.nuevo());
        juego.jugador(1).elegirAlgomon(Especie.RATTATA.nuevo());

        String jugadorQueEmpieza = juego.obtenerJugadorActivo().nombre();
        juego.pasarTurno();
        juego.pasarTurno();

        assertEquals(jugadorQueEmpieza,juego.obtenerJugadorActivo().nombre());
    }

    @Test
    public void cambiaElTurnoDespuesDeQueJugadorRealizaUnaAccion(){
        Juego juego = Juego.instancia();
        {
            Jugador mabel = new Jugador("Mabel");
            mabel.elegirAlgomon(Especie.BULBASAUR.nuevo());
            mabel.elegirAlgomon(Especie.CHANSEY.nuevo());
            mabel.elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
            juego.agregarJugador(mabel);
        }
        {
            Jugador nahuel = new Jugador("Nahuel");
            nahuel.elegirAlgomon(Especie.CHARMANDER.nuevo());
            nahuel.elegirAlgomon(Especie.RATTATA.nuevo());
            nahuel.elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
            juego.agregarJugador(nahuel);
        }

        //~ primer jugador se elige aleatoriamente: no se si es mabel o nahuel
        Jugador primero = juego.obtenerJugadorActivo();
        primero.cambiarAlgomonActivo(1);
        assertNotSame(primero, juego.obtenerJugadorActivo());
    }

    @Test
    public void cambiaElTurnoDespuesDeQueJugadorUsaItem(){
        Juego juego = Juego.instancia();
        {
            Jugador mabel = new Jugador("Mabel");
            mabel.elegirAlgomon(Especie.BULBASAUR.nuevo());
            mabel.elegirAlgomon(Especie.CHANSEY.nuevo());
            mabel.elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
            juego.agregarJugador(mabel);
        }
        {
            Jugador nahuel = new Jugador("Nahuel");
            nahuel.elegirAlgomon(Especie.CHARMANDER.nuevo());
            nahuel.elegirAlgomon(Especie.RATTATA.nuevo());
            nahuel.elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
            juego.agregarJugador(nahuel);
        }

        //~ primer jugador se elige aleatoriamente: no se si es mabel o nahuel
        Jugador primero = juego.obtenerJugadorActivo();
        primero.aplicar(Elemento.POCION);
        assertNotSame(primero, juego.obtenerJugadorActivo());
    }
}
