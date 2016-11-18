package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharmanderTest
{
    @Test
    public void brasasQuita32PuntosDeVidaABulbasaur()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        charmander.atacar(bulbasaur, Movimiento.BRASAS);

        assertEquals(vidaInicial - 32, bulbasaur.vida());
    }

    @Test
    public void brasasQuita8PuntosDeVidaASquirtle()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        charmander.atacar(squirtle, Movimiento.BRASAS);

        assertEquals(vidaInicial - 8, squirtle.vida());
    }

    @Test
    public void brasasQuita16PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, rattata.vida());
    }

    @Test
    public void brasasQuita16PuntosDeVidaAJigglypuff()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        charmander.atacar(jigglypuff, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, jigglypuff.vida());
    }


    @Test
    public void ataqueRapidoQuita10PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.ATAQUE_RAPIDO);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test (expected = CantidadDeAtaquesExcedidaException.class)
    public void fogonazoLevantaExcepcionSiExcedeSuCantidadDeUsos()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata1 = Especie.RATTATA.nuevo();
        Algomon rattata2 = Especie.RATTATA.nuevo();
        Algomon rattata3 = Especie.RATTATA.nuevo();
        Algomon rattata4 = Especie.RATTATA.nuevo();
        Algomon rattata5 = Especie.RATTATA.nuevo();

        charmander.atacar(rattata1, Movimiento.FOGONAZO);
        charmander.atacar(rattata2, Movimiento.FOGONAZO);
        charmander.atacar(rattata3, Movimiento.FOGONAZO);
        charmander.atacar(rattata4, Movimiento.FOGONAZO);
        charmander.atacar(rattata5, Movimiento.FOGONAZO);
    }

    @Test (expected = AlgomonNoPoseeElMovimientoException.class)
    public void charmanderLevantaExcepcionAlgomonNoPoseeElMovimientoExeption()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.BURBUJA);
    }

    @Test
    public void fogonazoLeQuita2PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, rattata.vida());
    }

    @Test
    public void fogonazoQuita17PuntosDeVidaPorQuemadurasARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        int vidaInicial = rattata.vida();
        rattata.turnoTerminado();

        assertEquals(vidaInicial - 17, rattata.vida());
    }
}
