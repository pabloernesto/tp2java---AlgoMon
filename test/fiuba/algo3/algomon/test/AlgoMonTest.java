package fiuba.algo3.algomon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.AlgoMon;
import fiuba.algo3.algomon.Especie;

public class AlgoMonTest {

	 @Test
	 public void creacionDeAlgomon() {
		 AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();

		 assertEquals(bulbasaur.vida(), 140);
	 }
	 
	 
	 
}
