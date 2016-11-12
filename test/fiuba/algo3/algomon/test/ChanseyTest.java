package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChanseyTest
{
    @Test
    public void latigoCepaQuita30PuntosDeVidaASquirtle()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        chansey.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void latigoCepaQuita7PuntosDeVidaACharmander()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        chansey.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void latigoCepaQuita15PuntosDeVidaAJigglypuff()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        chansey.atacar(jigglypuff, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, jigglypuff.vida());
    }
    
    @Test (expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void ataqueConCantoInhabilitaElAtaqueDeCharmander()
    {
    	Juego juego = new Juego();
    	
    	juego.agregarJugador(new Jugador("María"));
    	juego.agregarJugador(new Jugador("Juan"));
    	
    	juego.jugador(0).elegirAlgomones(	Especie.CHANSEY.nuevo(),
    										Especie.CHARMANDER.nuevo(),
    										Especie.RATTATA.nuevo());
    	juego.jugador(1).elegirAlgomones(	Especie.CHANSEY.nuevo(),
											Especie.CHARMANDER.nuevo(),
											Especie.RATTATA.nuevo());
    	
        juego.jugador(0).algomonNro(1).atacar(juego.jugador(1).algomonNro(2), Movimiento.CANTO);
        juego.jugador(1).algomonNro(2).atacar(juego.jugador(0).algomonNro(2), Movimiento.BRASAS);

    }
    
}
