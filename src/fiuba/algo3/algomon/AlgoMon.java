package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonEstaInhabilitadoParaAtacarException;
import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class AlgoMon
{
    int vida;
    Tipo tipo;
    Map<Movimiento, AtaqueNormal> ataques = new EnumMap<Movimiento, AtaqueNormal>(Movimiento.class);
    EstadoDeAlgomon estado = new EstadoDeAlgomonNormal();

    public AlgoMon(Tipo t, Movimiento [] movimientos, int vida)
    {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, new AtaqueNormal(m));

        this.vida = vida;
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
        try{
            estado.atacar(ataques.get(movimiento),enemigo);
            estado.turnoTerminado(this);
            return this;
        }
        catch(NullPointerException e){throw new AlgomonNoPoseeElMovimientoException();}
    }

    public int vida()
    {
        return vida;
    }

    public void recuperarEstado() 
    {
       this.estado = new EstadoDeAlgomonNormal(); 
    }

    public void estado(EstadoDeAlgomon efectoEfimero) 
    {
        this.estado = efectoEfimero;
    }

    public void turnoTerminado() 
    {
        this.estado.turnoTerminado(this);
    }
}
