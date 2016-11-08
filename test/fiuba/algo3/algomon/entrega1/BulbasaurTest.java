package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BulbasaurTest
{
    @Test
    public void latigoCepaQuita30PuntosDeVidaASquirtle()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void latigoCepaQuita7PuntosDeVidaACharmander()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        bulbasaur.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void latigoCepaQuita15PuntosDeVidaARattata()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        bulbasaur.atacar(rattata, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, rattata.vida());
    }
}
