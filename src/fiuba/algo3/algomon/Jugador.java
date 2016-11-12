package fiuba.algo3.algomon;

import java.util.ArrayList;

public class Jugador {

	private static final int MAX_CANT_ALGOMONES_POR_JUGADOR = 3;
	
	private String nombre;
	private ArrayList<AlgoMon> algomones;

	public Jugador(String nombreJugador) {
		this.nombre = nombreJugador;
		this.algomones = new ArrayList<AlgoMon>();
	}

	public void elegirAlgomon(AlgoMon algomon) {
		int i = 0;
		
		while (i <= MAX_CANT_ALGOMONES_POR_JUGADOR){
			if (this.algomones.size() == i){
				this.algomones.add(i, algomon);
				break;
			}
			i++;
		}
	}

	public AlgoMon algomonNro(int nroDeAlgomon) {
		return algomones.get(nroDeAlgomon-1);
	}

	public String getNombre() {
		return this.nombre;
	}


}
