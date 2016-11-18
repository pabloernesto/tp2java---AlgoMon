package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtaquesBasicosTest
{
    @Test
    public void bulbasaurUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        bulbasaur.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita15PuntosDeVidaAChansey()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon chansey = Especie.CHANSEY.nuevo();

        int vidaInicial = chansey.vida();

        bulbasaur.atacar(chansey, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, chansey.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        chansey.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        chansey.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita15PuntosDeVidaAJigglypuff()
    {
        AlgoMon chansey = Especie.CHANSEY.nuevo();
        AlgoMon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        chansey.atacar(jigglypuff, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, jigglypuff.vida());
    }
}