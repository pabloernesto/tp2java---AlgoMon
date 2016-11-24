package fiuba.algo3.algomon.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algomon.excepciones.CantidadElementosExcedidaException;
import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Elemento;
import fiuba.algo3.algomon.modelo.Especie;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.Movimiento;

public class JugadorTest {

	@Test (expected = ImposibleElegirMasDeTresAlgomonesException.class)
	public void MaximoTresAlgomonesPorJugador(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		juego.jugador(0).elegirAlgomon(Especie.BULBASAUR.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.SQUIRTLE.nuevo());
		
	}

	@Test
	public void primerAlgomonElegidoPorJugadorEsAlgomonActivoPorDefecto(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		Algomon primerAlgomon = Especie.BULBASAUR.nuevo();
		
		juego.jugador(0).elegirAlgomon(primerAlgomon);
		juego.jugador(0).elegirAlgomon(Especie.CHANSEY.nuevo());
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		
		assertEquals(juego.jugador(0).getAlgomonActivo(), primerAlgomon);		
	}
	
	@Test
	public void jugadorPuedeAtacarConAlgomonActivoYElegirElAtaque(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		juego.jugador(0).elegirAlgomon(Especie.CHARMANDER.nuevo());
		
        Algomon rattata = Especie.RATTATA.nuevo();
        int vidaInicial = rattata.vida();

        juego.jugador(0).getAlgomonActivo().atacar(rattata, Movimiento.ATAQUE_RAPIDO);	//El jugador lo elegira por interfaz

        assertEquals(vidaInicial - 10, rattata.vida());
	}
	
	@Test
	public void jugadorPuedeCambiarAlgomonActivo(){
		Juego juego = new Juego();
		
		juego.agregarJugador(new Jugador("Mabel"));
		
		juego.jugador(0).elegirAlgomon(Especie.CHARMANDER.nuevo());
		Algomon nuevoAlgomonActivo = Especie.CHANSEY.nuevo();
		juego.jugador(0).elegirAlgomon(nuevoAlgomonActivo);
		juego.jugador(0).elegirAlgomon(Especie.JIGGLYPUFF.nuevo());
		
		juego.jugador(0).cambiarAlgomonActivo(1);

        assertEquals(juego.jugador(0).getAlgomonActivo(),nuevoAlgomonActivo);
	}
	
	@Test
	public void jugadorPuedeAplicarlePocionAlAlgomonActivo(){
	    Jugador jugador = new Jugador("Yoda");
	    jugador.elegirAlgomon(Especie.CHARMANDER.nuevo());
	    Algomon atacado = jugador.getAlgomonActivo();
	    Algomon atacante = Especie.SQUIRTLE.nuevo();
        atacante.atacar(atacado, Movimiento.CANION_DE_AGUA);

	    int vidaInicial = atacado.vida();
	    jugador.aplicar(Elemento.POCION);

        assertEquals(vidaInicial + 20, atacado.vida());
	}

   @Test
    public void jugadorPuedeAplicarleSuperPocionAlAlgomonActivo(){
        Jugador jugador = new Jugador("Yoda");
        jugador.elegirAlgomon(Especie.CHARMANDER.nuevo());
        Algomon atacado = jugador.getAlgomonActivo();
        Algomon atacante = Especie.SQUIRTLE.nuevo();
        atacante.atacar(atacado, Movimiento.CANION_DE_AGUA);
        atacante.atacar(atacado, Movimiento.CANION_DE_AGUA);

        int vidaInicial = atacado.vida();
        jugador.aplicar(Elemento.SUPER_POCION);

        assertEquals(vidaInicial + 40, atacado.vida());
    }  

   @Test
    public void jugadorPuedeAplicarleRestauradorAlAlgomonActivo(){
        Jugador jugador = new Jugador("Yoda");
        jugador.elegirAlgomon(Especie.CHARMANDER.nuevo());
        Algomon algomonConEstado = jugador.getAlgomonActivo();
        Algomon atacado = Especie.JIGGLYPUFF.nuevo();
        int vidaInicial = atacado.vida();
        atacado.atacar(algomonConEstado, Movimiento.CANTO);

        jugador.aplicar(Elemento.RESTAURADOR);
        algomonConEstado.atacar(atacado, Movimiento.BRASAS);


        assertEquals(vidaInicial - 16, atacado.vida());
    }  

   @Test 
   public void jugadorPuedeAplicarleVitaminaAlAlgomonActivo()
   {
       Jugador jugador = new Jugador("Yoda");
       jugador.elegirAlgomon(Especie.CHARMANDER.nuevo());
       Algomon charmander = jugador.getAlgomonActivo();
       Algomon rattata1 = Especie.RATTATA.nuevo();
       Algomon rattata2 = Especie.RATTATA.nuevo();
       Algomon rattata3 = Especie.RATTATA.nuevo();
       Algomon rattata4 = Especie.RATTATA.nuevo();
       Algomon rattata5 = Especie.RATTATA.nuevo();

       charmander.atacar(rattata1, Movimiento.FOGONAZO);
       charmander.atacar(rattata2, Movimiento.FOGONAZO);
       charmander.atacar(rattata3, Movimiento.FOGONAZO);
       charmander.atacar(rattata4, Movimiento.FOGONAZO);


       jugador.aplicar(Elemento.VITAMINA);
       int vidaInicial = rattata5.vida();
       charmander.atacar(rattata5, Movimiento.FOGONAZO);
       charmander.atacar(rattata5, Movimiento.FOGONAZO);
       assertEquals(vidaInicial - 4, rattata5.vida());
   }

   @Test (expected = CantidadElementosExcedidaException.class)
   public void fogonazoLevantaExcepcionSiExcedeSuCantidadDeUsos()
   {
       Jugador jugador = new Jugador("Yoda");
       jugador.elegirAlgomon(Especie.CHARMANDER.nuevo());
       jugador.aplicar(Elemento.POCION);
       jugador.aplicar(Elemento.POCION);
       jugador.aplicar(Elemento.POCION);
       jugador.aplicar(Elemento.POCION);
       jugador.aplicar(Elemento.POCION);
   } 
}
