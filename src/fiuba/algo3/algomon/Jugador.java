package fiuba.algo3.algomon;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<AlgoMon> algomones;

	public Jugador(String nombreJugador) {
		this.nombre = nombreJugador;
		this.algomones = new ArrayList<AlgoMon>();
	}

	public void elegirAlgomones(AlgoMon algomon1, AlgoMon algomon2, AlgoMon algomon3) {
		this.algomones.add(0, algomon1);
		this.algomones.add(1, algomon2);
		this.algomones.add(2, algomon3);
	}

	public AlgoMon algomonNro(int nroDeAlgomon) {
		return algomones.get(nroDeAlgomon-1);
	}


}
