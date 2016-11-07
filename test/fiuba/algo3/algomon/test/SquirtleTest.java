package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SquirtleTest
{
    @Test
    public void burbujasQuita20PuntosDeVidaACharmander()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.BURBUJAS);

        assertEquals(vidaInicial - 20, charmander.vida());
    }

    @Test
    public void canionDeAguaQuita40PuntosDeVidaACharmander()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 40, charmander.vida());
    }

    @Test
    public void burbujaQuita5PuntosDeVidaABulbasaur()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.BURBUJAS);

        assertEquals(vidaInicial - 5, bulbasaur.vida());
    }

    @Test
    public void canionDeAguaQuita10PuntosDeVidaABulbasaur()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 10, bulbasaur.vida());
    }

    @Test
    public void burbujaQuita10PuntosDeVidaARattata()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.BURBUJAS);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test
    public void canionDeAguaQuita20PuntosDeVidaARattata()
    {
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 20, rattata.vida());
    }
}
