package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.Algomon;
import fiuba.algo3.algomon.Especie;

public class AlgoMonTest {

	 @Test
	 public void creacionDeAlgomon() {
		 Algomon bulbasaur = Especie.BULBASAUR.nuevo();

		 assertEquals(bulbasaur.vida(), 140);
	 }
	 
	 
	 
}
