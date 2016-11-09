package fiuba.algo3.algomon.test;

import fiuba.algo3.algomon.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharmanderTest {

	    @Test
	    public void brasasQuita32PuntosDeVidaABulbasaur()
	    {
	        AlgoMon charmander = Especie.CHARMANDER.nuevo();
	        AlgoMon bulbasaur = Especie.BULBASAUR.nuevo();

	        int vidaInicial = bulbasaur.vida();

	        charmander.atacar(bulbasaur, Movimiento.BRASAS);

	        assertEquals(vidaInicial - 32, bulbasaur.vida());
	    }


	}


