package fiuba.algo3.algomon.modelo;

import java.util.ArrayList;

import fiuba.algo3.algomon.excepciones.ImposibleElegirMasDeTresAlgomonesException;

public class Jugador {

    private static final int MAX_CANT_ALGOMONES_POR_JUGADOR = 3;

    private String nombre;
    private ArrayList<Algomon> algomones;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.algomones = new ArrayList<Algomon>();
    }

    public void elegirAlgomon(Algomon algomon) {
        int i = 0;

        while (i < MAX_CANT_ALGOMONES_POR_JUGADOR){
            if (this.algomones.size() == i){
                this.algomones.add(i, algomon);
                break;
            }
            i++;
        }

        if (i == MAX_CANT_ALGOMONES_POR_JUGADOR)
            throw new ImposibleElegirMasDeTresAlgomonesException();

    }

    public Algomon algomonNro(int nroDeAlgomon) {
        return this.algomones.get(nroDeAlgomon-1);
    }

    public String nombre() {
        return this.nombre;
    }

    public void actualizarEstadoAlgomones() {
        for (int i = 0; i < MAX_CANT_ALGOMONES_POR_JUGADOR; i++){
            this.algomones.get(i).turnoTerminado();
        }
    }


}
