package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtaquesBasicosTest
{
    @Test
    public void bulbasaurUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.getVida();

        bulbasaur.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.getVida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.getVida();

        bulbasaur.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.getVida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita15PuntosDeVidaAChansey()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon chansey = Especie.CHANSEY.nuevo();

        int vidaInicial = chansey.getVida();

        bulbasaur.atacar(chansey, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, chansey.getVida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.getVida();

        chansey.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.getVida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.getVida();

        chansey.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.getVida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita15PuntosDeVidaAJigglypuff()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.getVida();

        chansey.atacar(jigglypuff, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, jigglypuff.getVida());
    }

    @Test
    public void rattataUsaFogonazoQuita2PuntosDeVidaARattata()
    {
        Algomon atacante = Especie.RATTATA.nuevo();
        Algomon atacado = Especie.RATTATA.nuevo();

        int vidaInicial = atacado.getVida();

        atacante.atacar(atacado, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, atacado.getVida());
    }

    @Test
    public void squirtleUsaBurbujasQuita20PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.getVida();

        squirtle.atacar(charmander, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 20, charmander.getVida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita40PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.getVida();

        squirtle.atacar(charmander, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 40, charmander.getVida());
    }

    @Test
    public void squirtleUsaBurbujaQuita5PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.getVida();

        squirtle.atacar(bulbasaur, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 5, bulbasaur.getVida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita10PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.getVida();

        squirtle.atacar(bulbasaur, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 10, bulbasaur.getVida());
    }

    @Test
    public void squirtleUsaBurbujaQuita10PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.getVida();

        squirtle.atacar(rattata, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 10, rattata.getVida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita20PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.getVida();

        squirtle.atacar(rattata, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 20, rattata.getVida());
    }

    @Test
    public void charmanderUsaBrasasQuita32PuntosDeVidaABulbasaur()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.getVida();

        charmander.atacar(bulbasaur, Movimiento.BRASAS);

        assertEquals(vidaInicial - 32, bulbasaur.getVida());
    }

    @Test
    public void charmanderUsaBrasasQuita8PuntosDeVidaASquirtle()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.getVida();

        charmander.atacar(squirtle, Movimiento.BRASAS);

        assertEquals(vidaInicial - 8, squirtle.getVida());
    }

    @Test
    public void charmanderUsaBrasasQuita16PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.getVida();

        charmander.atacar(rattata, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, rattata.getVida());
    }

    @Test
    public void charmanderUsaBrasasQuita16PuntosDeVidaAJigglypuff()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.getVida();

        charmander.atacar(jigglypuff, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, jigglypuff.getVida());
    }


    @Test
    public void charmanderUsaAtaqueRapidoQuita10PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.getVida();

        charmander.atacar(rattata, Movimiento.ATAQUE_RAPIDO);

        assertEquals(vidaInicial - 10, rattata.getVida());
    }

    @Test
    public void charmanderUsaFogonazoLeQuita2PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.getVida();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, rattata.getVida());
    }
}
