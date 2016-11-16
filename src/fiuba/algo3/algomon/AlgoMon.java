package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class AlgoMon {
	
    int vida;
    Tipo tipo;
    Map<Movimiento, AtaqueNormal> ataques = new EnumMap<Movimiento, AtaqueNormal>(Movimiento.class);
    EstadoDeAlgomon estado = new EstadoDeAlgomonNormal();
    private int vidaOriginal;

    public AlgoMon(Tipo t, Movimiento [] movimientos, int vida) {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, new AtaqueNormal(m));

        this.vida = vida;
        this.vidaOriginal = vida;
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento) {
        try{
            estado.estadoDelAtacante(ataques.get(movimiento),this);
            estado.atacar(ataques.get(movimiento),enemigo);
            estado.turnoTerminado(this);
            return this;
        }
        catch(NullPointerException e){throw new AlgomonNoPoseeElMovimientoException();}
    }

    public int vidaOriginal() {
        return this.vidaOriginal;
    }

    public int vida() {
        return vida;
    }

    public void recuperarEstado() {
       this.estado = new EstadoDeAlgomonNormal(); 
    }

    public void estado(EstadoDeAlgomon efectoEfimero) { //rename
        this.estado = efectoEfimero;
    }

    public void turnoTerminado() {
        this.estado.turnoTerminado(this);
    }

    public void causarDanio(int potencia) {
        this.estado.causarDanio(potencia, this);
    }
}
