package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;

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

    @Test (expected = CantidadDeAtaquesExcedidaException.class)
    public void fogonazoLevantaExcepcionSiExcedeSuCantidadDeUsos()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata1 = Especie.RATTATA.nuevo();
        Algomon rattata2 = Especie.RATTATA.nuevo();
        Algomon rattata3 = Especie.RATTATA.nuevo();
        Algomon rattata4 = Especie.RATTATA.nuevo();
        Algomon rattata5 = Especie.RATTATA.nuevo();

        charmander.atacar(rattata1, Movimiento.FOGONAZO);
        charmander.atacar(rattata2, Movimiento.FOGONAZO);
        charmander.atacar(rattata3, Movimiento.FOGONAZO);
        charmander.atacar(rattata4, Movimiento.FOGONAZO);
        charmander.atacar(rattata5, Movimiento.FOGONAZO);
    }

    @Test (expected = CantidadDeAtaquesExcedidaException.class)
    public void cantoLevantaExcepcionSiExcedeSuCantidadDeUsos()
    {
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();
        Algomon rattata1 = Especie.RATTATA.nuevo();

        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
        jigglypuff.atacar(rattata1, Movimiento.CANTO);
    }

    @Test (expected = AlgomonNoPoseeElMovimientoException.class)
    public void charmanderUsaBurbujaLevantaExcepcion()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.BURBUJA);
    }
}
