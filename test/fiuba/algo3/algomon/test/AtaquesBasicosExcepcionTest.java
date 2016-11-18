package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtaquesBasicosExcepcionTest
{
    @Test (expected = CantidadDeAtaquesExcedidaException.class)
    public void usarFogonazo5VecesCausaUnaExcepcion()
    {
        Algomon rattata = Especie.RATTATA.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        rattata
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO)
            .atacar(squirtle, Movimiento.FOGONAZO);
    }
}
