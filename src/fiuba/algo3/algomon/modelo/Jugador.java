package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;

public class Jugador {

    private static final int MAX_CANT_ALGOMONES_POR_JUGADOR = 3;
    private static final Elemento[] mochilaBasica = new Elemento[]{Elemento.POCION, Elemento.SUPER_POCION, Elemento.RESTAURADOR,Elemento.VITAMINA};

    private String nombre;
    private ArrayList<Algomon> algomones;
    private Algomon algomonActivo;
    Map<Elemento, Item> mochila = new EnumMap<Elemento, Item>(Elemento.class);

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.algomones = new ArrayList<Algomon>();
        
        for (Elemento elemento : mochilaBasica) {
            Item nuevoItem = elemento.nuevo();

            mochila.put(elemento, nuevoItem);
        }
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

	public void cambiarAlgomonActivo(int nuevoAlgomonActivo) {
		this.algomonActivo = this.algomones.get(nuevoAlgomonActivo);		
	}

    public void aplicar(Elemento pocion) {
        mochila.get(pocion).aplicar(this.getAlgomonActivo());
    }
}
