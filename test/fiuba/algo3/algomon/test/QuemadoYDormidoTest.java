package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuemadoYDormidoTest
{
    @Test(expected = AlgomonEstaInhabilitadoParaAtacarException.class)
    public void rattataQuemadoYDormidoNoPuedeAtacar()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);
        jigglypuff.atacar(rattata, Movimiento.CANTO);

        rattata.atacar(charmander, Movimiento.ATAQUE_RAPIDO);
    }

    @Test
    public void alFinalizarCantoRattataSigueQuemado()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);
        jigglypuff.atacar(rattata, Movimiento.CANTO);

        int vidaInicial = rattata.vida();
        rattata
            .turnoTerminado()
            .turnoTerminado()
            .turnoTerminado()
            .atacar(charmander, Movimiento.ATAQUE_RAPIDO);

        assertTrue(
            "La vida de rattata debe disminuir "
            + "cuando ataca porque esta quemado",
            rattata.vida() < vidaInicial);
    }
}
