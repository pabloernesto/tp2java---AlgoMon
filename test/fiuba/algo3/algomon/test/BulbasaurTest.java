package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;

import org.junit.Test;
import static org.junit.Assert.*;

public class BulbasaurTest
{
    @Test
    public void latigoCepaQuita30PuntosDeVidaASquirtle()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();

        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test
    public void latigoCepaQuita7PuntosDeVidaACharmander()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon charmander = Especie.CHARMANDER.nuevo();

        int vidaInicial = charmander.vida();

        bulbasaur.atacar(charmander, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 7, charmander.vida());
    }

    @Test
    public void latigoCepaQuita15PuntosDeVidaAChansey()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon chansey = Especie.CHANSEY.nuevo();

        int vidaInicial = chansey.vida();

        bulbasaur.atacar(chansey, Movimiento.LATIGO_CEPA);

        assertEquals(vidaInicial - 15, chansey.vida());
    }

    @Test
    public void ataqueConChupaVidasLeQuita30PuntosASquirtle()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        
        int vidaInicial = squirtle.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial - 30, squirtle.vida());
    }

    @Test 
    public void ataqueConChupaVidasASquirtleBulbasaurGana9Puntos()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        
        int vidaInicial = bulbasaur.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.vida());
    }

    @Test 
    public void ataqueConChupaVidasBulbasaurGana9Puntos()
    {
        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
        AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
        
        int vidaInicial = bulbasaur.vida();

        bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

        assertEquals(vidaInicial + 9, bulbasaur.vida());
    }

     @Test
     public void ataqueConChupaVidasLeQuita7PuntosACharmander()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon charmander = Especie.CHARMANDER.nuevo();
         
         int vidaInicial = charmander.vida();

         bulbasaur.atacar(charmander, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial - 7, charmander.vida());
 }

     @Test 
     public void ataqueConChupaVidasCharmanderGana2Puntos()
     {
         AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();
         AlgoMon squirtle = Especie.SQUIRTLE.nuevo();
         
         int vidaInicial = bulbasaur.vida();

         bulbasaur.atacar(squirtle, Movimiento.CHUPAVIDAS);

         assertEquals(vidaInicial + 9, bulbasaur.vida());
     } 
}
