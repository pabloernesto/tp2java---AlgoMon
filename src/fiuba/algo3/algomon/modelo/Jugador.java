package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.Observable;

import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;
import fiuba.algo3.algomon.excepciones.juegoTerminadoException;
import fiuba.algo3.algomon.modelo.elementos.Elemento;
import fiuba.algo3.algomon.modelo.elementos.Item;

public class Jugador extends Observable{

    private static final int MAX_CANT_ALGOMONES_POR_JUGADOR = 3;
    private static final Elemento[] mochilaBasica = new Elemento[]{Elemento.POCION, Elemento.SUPER_POCION, Elemento.RESTAURADOR,Elemento.VITAMINA};

    private String nombre;
    private ArrayList<Algomon> algomones;
    private Algomon algomonActivo;
    Map<Elemento, Item> mochila = new EnumMap<Elemento, Item>(Elemento.class);
	private Algomon[] algomonesConscientes;

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
        try {
			this.cambiarAlgomonActivo();
		} catch (juegoTerminadoException e) {
		}
    }

    public Algomon algomonNro(int nroDeAlgomon) {
        return this.algomones.get(nroDeAlgomon-1);
    }

    public String nombre() {
        return this.nombre;
    }

    public void terminarTurno() { // cambiar nombre
        for (Algomon a : algomones)
            a.turnoTerminado();
    }

    public ArrayList<Algomon> getAlgomones(){
        return this.algomones;
    }

    public Algomon getAlgomonActivo() {
        return this.algomonActivo;
    }

    public Item[] mochila() {
        return mochila.values().toArray(new Item[mochila.values().size()]);
    }

    public void cambiarAlgomonActivo(int nuevoAlgomonActivo) {  
    	this.algomonActivo = this.algomones.get(nuevoAlgomonActivo);
        setChanged();       // refactor
        notifyObservers();
    }

    public void aplicar(Elemento pocion) {
        mochila.get(pocion).aplicar(this.getAlgomonActivo());
        setChanged();       // refactor
        notifyObservers();
    }

    public void reemplazarAlgomonSiEstaDesmayado()  throws juegoTerminadoException{
//       algomonActivo.pedirCambioSiEstaDesmayado(this); refactor
    	this.cambiarAlgomonActivo();
    }

//    public void cambiarAlgomonActivo() {
//        algomonesConscientes = null;
//        algomonesConscientes = algomones.stream().filter(algomon -> algomon.puedePelear()).toArray(Algomon[]::new);
//        
//        try {
//			cambiarAlgomonActivo(algomonesConscientes[0]);
//			setChanged();
//	        notifyObservers();
//        } catch (juegoTerminadoException e) {
//			// la exception es manejada en la interfaz
//		}
//    }

    public boolean quedanAlgomonesConscientes() {
		return (algomonesConscientes.length != 0);
	}

	public void cambiarAlgomonActivo() throws juegoTerminadoException {
		algomonesConscientes = null;
		algomonesConscientes = algomones.stream().filter(algomon -> algomon.puedePelear()).toArray(Algomon[]::new);
		if (!quedanAlgomonesConscientes())
    		throw new juegoTerminadoException();
    	else {
			this.algomonActivo = algomonesConscientes[0];
	        setChanged();
	        notifyObservers();
    	}
    }

	public void cambiarAlgomonActivo(Algomon algomon) {
		algomonActivo = algomon;
		setChanged();
		notifyObservers();
	}
}
