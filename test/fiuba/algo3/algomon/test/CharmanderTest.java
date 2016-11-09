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
        AlgoMon charmander = Especie.CHARMANDER.nuevo();
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        charmander.atacar(bulbasaur, Movimiento.BRASAS);

        assertEquals(vidaInicial - 32, bulbasaur.vida());
    }

    @Test
    public void brasasQuita8PuntosDeVidaASquirtle()
    {
        AlgoMon charmander = Especie.CHARMANDER.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        charmander.atacar(squirtle, Movimiento.BRASAS);

        assertEquals(vidaInicial - 8, squirtle.vida());
    }

    @Test
    public void brasasQuita16PuntosDeVidaARattata()
    {
        AlgoMon charmander = Especie.CHARMANDER.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, rattata.vida());
    }

    @Test
    public void ataqueRapidoQuita10PuntosDeVidaARattata()
    {
        AlgoMon charmander = Especie.CHARMANDER.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.ATAQUE_RAPIDO);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test (expected = CantidadDeAtaquesExcedidaException.class)
    public void fogonazoLevantaExcepcionSiExcedeSuCantidadDeUsos()
    {
        AlgoMon charmander = Especie.CHARMANDER.nuevo();
        AlgoMon rattata1 = Especie.RATTATA.nuevo();
        AlgoMon rattata2 = Especie.RATTATA.nuevo();
        AlgoMon rattata3 = Especie.RATTATA.nuevo();
        AlgoMon rattata4 = Especie.RATTATA.nuevo();
        AlgoMon rattata5 = Especie.RATTATA.nuevo();

        charmander.atacar(rattata1, Movimiento.FOGONAZO);
        charmander.atacar(rattata2, Movimiento.FOGONAZO);
        charmander.atacar(rattata3, Movimiento.FOGONAZO);
        charmander.atacar(rattata4, Movimiento.FOGONAZO);
        charmander.atacar(rattata5, Movimiento.FOGONAZO);
    }
}
