package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChupavidasTest
{
    @Test
    public void bulbasaurUsaChupaVidasLeQuita30PuntosASquirtle()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void bulbasaurUsaChupaVidasASquirtleBulbasaurGana9Puntos()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = bulbasaur.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.vida());
    }

    @Test
    public void bulbasaurUsaChupaVidasBulbasaurGana9Puntos()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = bulbasaur.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.vida());
    }

     @Test
     public void bulbasaurUsaChupaVidasLeQuita7PuntosACharmander()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon charmander = Especie.CHARMANDER.nuevo();

         int vidaInicial = charmander.vida();

         bulbasaur.atacar(charmander, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial - 7, charmander.vida());
 }

     @Test
     public void bulbasaurUsaChupaVidasCharmanderGana2Puntos()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

         int vidaInicial = bulbasaur.vida();

         bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial + 9, bulbasaur.vida());
     }

     @Test
     public void bulbasaurUsaChupaVidasLeQuita15PuntosARattata()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon rattata = Especie.RATTATA.nuevo();

         int vidaInicial = rattata.vida();

         bulbasaur.atacar(rattata, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial - 15, rattata.vida());
 }

     @Test
     public void bulbasaurUsaChupaVidasRattataGana4Puntos()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon rattata = Especie.RATTATA.nuevo();

         int vidaInicial = bulbasaur.vida();

         bulbasaur.atacar(rattata, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial + 4, bulbasaur.vida());
     }
}
