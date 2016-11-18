package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class Algomon {

    int vida;
    Tipo tipo;
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);
    EstadoDeAlgomon estado = new EstadoDeAlgomonNormal();
    private int vidaOriginal;

    public Algomon(Tipo t, Movimiento [] movimientos, int vida) {
        tipo = t;

        for (Movimiento m : movimientos)
            ataques.put(m, m.nuevo());

        this.vida = vida;
        this.vidaOriginal = vida;
    }

    public Algomon atacar(Algomon enemigo, Movimiento movimiento) {
        try{
        	
        	//this.estadoEfimero.consecuencia(); 
        	//this.estadoPermanente.consecuencia(this);
        	//this.ataques.get(movimiento).atacar(enemigo);
        	
        	this.estado.estadoDelAtacante(ataques.get(movimiento),this);
            this.estado.atacar(ataques.get(movimiento),enemigo);
            this.estado.turnoTerminado(this);
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
