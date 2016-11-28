package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.vista.Ejecutar;
import fiuba.algo3.algomon.vista.PantallaJugador;

public class JugadoresControlador {

	public JugadoresControlador(PantallaJugador pantallaJugador, Ejecutar aplicacion){
		
		aplicacion.getModelo().agregarJugador(new Jugador(pantallaJugador.txtNombreJugador1.getText()));
		aplicacion.getModelo().agregarJugador(new Jugador(pantallaJugador.txtNombreJugador2.getText()));
		
	}
}
