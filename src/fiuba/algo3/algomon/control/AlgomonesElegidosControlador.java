package fiuba.algo3.algomon.control;

import java.util.ArrayList;

import fiuba.algo3.algomon.excepciones.SeDebenElegirTresAlgomonesPorJugadorException;
import fiuba.algo3.algomon.vista.PantallaEleccionAlgomones;

public class AlgomonesElegidosControlador {

	private Ejecutar aplicacion;
	private ArrayList<String> algomonesElegidos;

	public AlgomonesElegidosControlador(PantallaEleccionAlgomones pantallaEleccionAlgomones, Ejecutar aplicacion,
			ArrayList<String> algomones, int nroDeJugador) throws SeDebenElegirTresAlgomonesPorJugadorException {
		this.aplicacion = aplicacion;
		this.algomonesElegidos = algomones;
		
		if (algomones.size() != 3){
			throw new SeDebenElegirTresAlgomonesPorJugadorException();
		}else{
			agregarAlgomonesA(nroDeJugador);
		}
	}

	private void agregarAlgomonesA(int nroDeJugador) {
		for(int i = 0; i <= 2; i++){
			switch (algomonesElegidos.get(i)) {
			case "Squirtle": aplicacion.getModelo();
			}
		}
	}

}
