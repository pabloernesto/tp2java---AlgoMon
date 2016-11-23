package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;

import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;

public class Jugador {

    private static final int MAX_CANT_ALGOMONES_POR_JUGADOR = 3;

    private String nombre;
    private ArrayList<Algomon> algomones;
    private Algomon algomonActivo;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.algomones = new ArrayList<Algomon>();
    }

    public void elegirAlgomon(Algomon algomon) {

    	switch (algomones.size()){
    	case MAX_CANT_ALGOMONES_POR_JUGADOR: 
    		throw new ImposibleElegirMasDeTresAlgomonesException();
    	case 0:
    		this.algomonActivo = algomon;
    		break;
    	}

    	algomones.add(algomon);
    }

    public Algomon algomonNro(int nroDeAlgomon) {
        return this.algomones.get(nroDeAlgomon-1);
    }

    public String nombre() {
        return this.nombre;
    }

    public void terminarTurno() {

        for (Algomon a : algomones)
            a.turnoTerminado();
    }
    
    public ArrayList<Algomon> getAlgomones(){
    	return this.algomones;
    }

	public Algomon getAlgomonActivo() {
		return this.algomonActivo;
	}
}
