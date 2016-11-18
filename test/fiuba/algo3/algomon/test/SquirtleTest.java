package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SquirtleTest
{
    @Test
    public void burbujasQuita20PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 20, charmander.vida());
    }

    @Test
    public void canionDeAguaQuita40PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 40, charmander.vida());
    }

    @Test
    public void burbujaQuita5PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 5, bulbasaur.vida());
    }

    @Test
    public void canionDeAguaQuita10PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 10, bulbasaur.vida());
    }

    @Test
    public void burbujaQuita10PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test
    public void canionDeAguaQuita20PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 20, rattata.vida());
    }
}
