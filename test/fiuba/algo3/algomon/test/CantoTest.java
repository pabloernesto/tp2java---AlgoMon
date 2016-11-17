package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

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
}
