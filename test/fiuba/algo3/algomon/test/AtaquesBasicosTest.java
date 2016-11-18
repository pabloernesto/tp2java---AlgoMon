package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtaquesBasicosTest
{
    @Test
    public void bulbasaurUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        bulbasaur.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void bulbasaurUsaLatigoCepaQuita15PuntosDeVidaAChansey()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon chansey = Especie.CHANSEY.nuevo();

        int vidaInicial = chansey.vida();

        bulbasaur.atacar(chansey, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, chansey.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita30PuntosDeVidaASquirtle()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        chansey.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita7PuntosDeVidaACharmander()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        chansey.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void chanseyUsaLatigoCepaQuita15PuntosDeVidaAJigglypuff()
    {
        Algomon chansey = Especie.CHANSEY.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        chansey.atacar(jigglypuff, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, jigglypuff.vida());
    }

    @Test
    public void rattataUsaFogonazoQuita2PuntosDeVidaARattata()
    {
        Algomon atacante = Especie.RATTATA.nuevo();
        Algomon atacado = Especie.RATTATA.nuevo();

        int vidaInicial = atacado.vida();

        atacante.atacar(atacado, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, atacado.vida());
    }

    @Test
    public void squirtleUsaBurbujasQuita20PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 20, charmander.vida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita40PuntosDeVidaACharmander()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        squirtle.atacar(charmander, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 40, charmander.vida());
    }

    @Test
    public void squirtleUsaBurbujaQuita5PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 5, bulbasaur.vida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita10PuntosDeVidaABulbasaur()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        squirtle.atacar(bulbasaur, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 10, bulbasaur.vida());
    }

    @Test
    public void squirtleUsaBurbujaQuita10PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.BURBUJA);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test
    public void squirtleUsaCanionDeAguaQuita20PuntosDeVidaARattata()
    {
        Algomon squirtle = Especie.SQUIRTLE.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        squirtle.atacar(rattata, Movimiento.CANION_DE_AGUA);

        assertEquals(vidaInicial - 20, rattata.vida());
    }

    @Test
    public void charmanderUsaBrasasQuita32PuntosDeVidaABulbasaur()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();

        int vidaInicial = bulbasaur.vida();

        charmander.atacar(bulbasaur, Movimiento.BRASAS);

        assertEquals(vidaInicial - 32, bulbasaur.vida());
    }

    @Test
    public void charmanderUsaBrasasQuita8PuntosDeVidaASquirtle()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        charmander.atacar(squirtle, Movimiento.BRASAS);

        assertEquals(vidaInicial - 8, squirtle.vida());
    }

    @Test
    public void charmanderUsaBrasasQuita16PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, rattata.vida());
    }

    @Test
    public void charmanderUsaBrasasQuita16PuntosDeVidaAJigglypuff()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon jigglypuff = Especie.JIGGLYPUFF.nuevo();

        int vidaInicial = jigglypuff.vida();

        charmander.atacar(jigglypuff, Movimiento.BRASAS);

        assertEquals(vidaInicial - 16, jigglypuff.vida());
    }


    @Test
    public void charmanderUsaAtaqueRapidoQuita10PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.ATAQUE_RAPIDO);

        assertEquals(vidaInicial - 10, rattata.vida());
    }

    @Test
    public void charmanderUsaFogonazoLeQuita2PuntosDeVidaARattata()
    {
        Algomon charmander = Especie.CHARMANDER.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = rattata.vida();

        charmander.atacar(rattata, Movimiento.FOGONAZO);

        assertEquals(vidaInicial - 2, rattata.vida());
    }
}
