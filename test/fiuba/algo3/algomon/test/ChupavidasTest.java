package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Movimiento;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChupavidasTest
{
    @Test
    public void bulbasaurUsaChupaVidasLeQuita30PuntosASquirtle()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.getVida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial - 30, squirtle.getVida());
    }

    @Test
    public void bulbasaurUsaChupaVidasEnSquirtleYRecupera9Puntos()
    {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        //~ bulbasaur queda con 1 pto de vida
        bulbasaur.causarDanio(bulbasaur.getVidaOriginal() - 1);
        int vidaInicial = bulbasaur.getVida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.getVida());
    }

    @Test
    public void bulbasaurUsaChupaVidasLeQuita7PuntosACharmander() {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.getVida();

        bulbasaur.atacar(charmander, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial - 7, charmander.getVida());
    }

    @Test
    public void bulbasaurUsaChupaVidasEnCharmanderYRecupera9Puntos() {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon squirtle = Especie.SQUIRTLE.nuevo();

        //~ bulbasaur queda con 1 pto de vida
        bulbasaur.causarDanio(bulbasaur.getVidaOriginal() - 1);
        int vidaInicial = bulbasaur.getVida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.getVida());
    }

     @Test
     public void bulbasaurUsaChupaVidasLeQuita15PuntosARattata()
     {
         Algomon bulbasaur = Especie.BULBASAUR.nuevo();
         Algomon rattata = Especie.RATTATA.nuevo();

         int vidaInicial = rattata.getVida();

         bulbasaur.atacar(rattata, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial - 15, rattata.getVida());
 }

     @Test
     public void bulbasaurUsaChupaVidasEnRattataYRecupera4Puntos()
     {
         Algomon bulbasaur = Especie.BULBASAUR.nuevo();
         Algomon rattata = Especie.RATTATA.nuevo();

         //~ bulbasaur queda con 1 pto de vida
         bulbasaur.causarDanio(bulbasaur.getVidaOriginal() - 1);
         int vidaInicial = bulbasaur.getVida();

         bulbasaur.atacar(rattata, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial + 4, bulbasaur.getVida());
     }

    @Test
    public void bulbasaurConVidaCompletaUsaChupaVidasYNoRecuperaVida() {
        Algomon bulbasaur = Especie.BULBASAUR.nuevo();
        Algomon rattata = Especie.RATTATA.nuevo();

        int vidaInicial = bulbasaur.getVida();
        bulbasaur.atacar(rattata, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial, bulbasaur.getVida());
    }
}
