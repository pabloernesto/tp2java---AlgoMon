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
}
