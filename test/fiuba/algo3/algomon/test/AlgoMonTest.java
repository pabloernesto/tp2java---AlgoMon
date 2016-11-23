package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Especie;

public class AlgoMonTest {

     @Test
     public void creacionDeAlgomon() {
         Algomon bulbasaur = Especie.BULBASAUR.nuevo();

         assertEquals(bulbasaur.vida(), 140);
     }

     @Test
     public void causarDanioNoBajaVidaAMenosDeCero() {

         Algomon bulbasaur = Especie.BULBASAUR.nuevo();
         int v = bulbasaur.vida();
         bulbasaur.causarDanio(2 * v);

         assertEquals(0, bulbasaur.vida());
     }
}
