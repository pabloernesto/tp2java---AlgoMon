package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
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
    public void latigoCepaQuita15PuntosDeVidaARattata()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        chansey.atacar(rattata, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, rattata.vida());
    }
}
