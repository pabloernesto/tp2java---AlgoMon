package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

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
}
