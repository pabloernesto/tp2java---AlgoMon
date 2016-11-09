package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.CantidadDeAtaquesExcedidaException;

import java.util.EnumMap;

public class AlgoMon
{
    int vida = 100;
    Tipo tipo;
    Map<Movimiento, Ataque> ataques = new EnumMap(Movimiento.class);

    public AlgoMon(Tipo t, Movimiento [] movimientos)
    {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, new Ataque(m));
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
        ataques.get(movimiento).atacar(enemigo);

        return this;
    }

    public int vida()
    {
        return vida;
    }
}
