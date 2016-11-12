package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;
import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class AlgoMon
{
    int vida;
    Tipo tipo;
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);
    boolean dormido;

    public AlgoMon(Tipo t, Movimiento [] movimientos, int vida)
    {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, new Ataque(m));

        this.vida = vida;
        this.dormido = false;
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
    	if (dormido)
    		throw new AlgomonEstaInhabilitadoParaAtacarException();
    	
        try{
            ataques.get(movimiento).atacar(enemigo);
            return this;
        }
        catch(NullPointerException e){throw new AlgomonNoPoseeElMovimientoException();}
        
    }

    public int vida()
    {
        return vida;
    }
}
