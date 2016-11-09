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
    public void latigoCepaQuita15PuntosDeVidaAJigglypuff()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        chansey.atacar(jigglypuff, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, jigglypuff.vida());
    }
}
