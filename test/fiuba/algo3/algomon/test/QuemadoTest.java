package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuemadoTest
{
    @Test
    public void fogonazoQuita17PuntosDeVidaPorQuemadurasARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        int vidaInicial = rattata.vida();
        // rattata no pierde vida si no realiza una accion
        rattata.atacar(charmander, Movimiento.ATAQUE_RAPIDO);

        assertEquals(vidaInicial - 17, rattata.vida());
    }


    @Test
    public void pasarTurnoSinRealizarAccionNoCausaDanio()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        int vidaInicial = rattata.vida();
        rattata
            .turnoTerminado()
            .turnoTerminado()
            .turnoTerminado();

        assertEquals(vidaInicial, rattata.vida());
    }
}
