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
    int turnosRestantesDormido; //refactorizar

    public AlgoMon(Tipo t, Movimiento [] movimientos, int vida)
    {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, new AtaqueNormal(m));

        this.vida = vida;
        this.turnosRestantesDormido = 0;
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
    	if (turnosRestantesDormido != 0)
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

	public void turnoTerminado() {
		if (turnosRestantesDormido >0) this.turnosRestantesDormido--;
	}

    public void manejoDeEstado(Ataque ataque) {
        // TODO Auto-generated method stub
        
    }
}
