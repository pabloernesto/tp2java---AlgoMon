package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RattataTest
{
    @Test (expected = RuntimeException.class)
    public void usarFogonazo5VecesCausaUnaExcepcion()
    {
        AlgoMon rattata = Especie.RATTATA.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        rattata
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO);
    }
}
