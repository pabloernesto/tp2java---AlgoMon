package fiuba.algo3.algomon.control;

import fiuba.algo3.algomon.excepciones.IngresarDosJugadoresException;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.vista.PantallaJugador;

public class JugadoresControlador {

    Juego j;
    PantallaJugador p;

    public JugadoresControlador(PantallaJugador pantallaJugador,
        Ejecutar aplicacion){

        j = Juego.instancia();
        p = pantallaJugador;

    }

    public void agregarJugadores() throws IngresarDosJugadoresException {
    	
        String n1 = p.txtNombreJugador1.getText();
        String n2 = p.txtNombreJugador2.getText();

        if (n1.isEmpty() || n2.isEmpty())
        	throw new IngresarDosJugadoresException();
        
        j.agregarJugador(new Jugador(n1));
        j.agregarJugador(new Jugador(n2));
    }
}
