package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RattataTest
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

    @Test
    public void fogonazoQuita2PuntosDeVidaARattata()
    {
        Algomon atacante = Especie.RATTATA.nuevo();
        Algomon atacado = Especie.RATTATA.nuevo();

        int vidaInicial = atacado.vida();

        atacante.atacar(atacado, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, atacado.vida());
    }
}
