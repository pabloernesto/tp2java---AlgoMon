package fiuba.algo3.algomon.control;

import java.util.ArrayList;

import fiuba.algo3.algomon.vista.PantallaEleccionAlgomones;
import fiuba.algo3.algomon.excepciones.SeDebenElegirTresAlgomonesPorJugadorException;

import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Jugador;
import fiuba.algo3.algomon.modelo.Juego;
import fiuba.algo3.algomon.modelo.Especie;


public class AlgomonesElegidosControlador {

    PantallaEleccionAlgomones pantalla;
    Ejecutar aplicacion;
    ArrayList<String> nombresDeEspecie;
    int n;

    public AlgomonesElegidosControlador(
        PantallaEleccionAlgomones pantallaEleccionAlgomones,
        Ejecutar aplicacion,
        ArrayList<String> algomones,
        int nroDeJugador) throws SeDebenElegirTresAlgomonesPorJugadorException {

        if (algomones.size() != 3) throw new SeDebenElegirTresAlgomonesPorJugadorException();

        pantalla = pantallaEleccionAlgomones;
        this.aplicacion = aplicacion;
        nombresDeEspecie = algomones;
        n = nroDeJugador;
    }

    public void agregarAlgomones() {
        Algomon[] algomones = nombresDeEspecie
            .stream()
            .map(s -> s.toUpperCase())
            .map(s -> Enum.valueOf(Especie.class, s))
            .map(especie -> especie.nuevo())
            .toArray(Algomon[]::new);
        Jugador j = Juego.instancia().jugador(n);
        for (Algomon a : algomones)
            j.elegirAlgomon(a);
    }
}
