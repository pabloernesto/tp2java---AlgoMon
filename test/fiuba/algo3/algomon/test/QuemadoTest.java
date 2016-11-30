package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.excepciones.CantidadDeAtaquesExcedidaException;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;
import fiuba.algo3.algomon.modelo.elementos.Elemento;
import fiuba.algo3.algomon.modelo.elementos.Vitamina;

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
    public void fogonazoNoSurteEfectoSiNoLeQuedanUsos()
    {
        Algomon rattata = Especie.RATTATA.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattataAtacado = Especie.RATTATA.nuevo();

        try{
        charmander
            .atacar(rattata, Movimiento.FOGONAZO)
            .atacar(rattata, Movimiento.FOGONAZO)
            .atacar(rattata, Movimiento.FOGONAZO)
            .atacar(rattata, Movimiento.FOGONAZO)
            .atacar(rattataAtacado, Movimiento.FOGONAZO);}
        catch (CantidadDeAtaquesExcedidaException e) {
            int vidaInicial = rattataAtacado.vida();
            // rattata no pierde vida si no realiza una accion
            rattataAtacado.atacar(rattata, Movimiento.ATAQUE_RAPIDO);
            assertEquals(vidaInicial , rattataAtacado.vida());
        }

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
    @Test
    public void quemadoLeQuita17PuntosARattataSiEsteUsaUnElemento()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        Vitamina vitamina = (Vitamina)Elemento.VITAMINA.nuevo();

        int vidaInicial = rattata.vida();
        // rattata no pierde vida si no realiza una accion
        rattata.aplicar(vitamina);

        assertEquals(vidaInicial - 17, rattata.vida());
    }
}
