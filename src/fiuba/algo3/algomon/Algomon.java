package fiuba.algo3.algomon;

import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

import java.util.EnumMap;

public class Algomon {

	Tipo tipo;
    int vida;
    private int vidaOriginal;
    EstadoDeAlgomon estadoEfimero = new EstadoDeAlgomonNormal();
    EstadoDeAlgomon estadoPermanente = new EstadoDeAlgomonNormal();
    Map<Movimiento, Ataque> ataques = new EnumMap<Movimiento, Ataque>(Movimiento.class);
    
    public Algomon(Tipo tipo, Movimiento [] movimientos, int vida) {
        
    	this.tipo = tipo;
        this.vida = vida;
        this.vidaOriginal = vida;
        
        for (Movimiento m : movimientos)
            ataques.put(m, m.nuevo());        
    }

    public Algomon atacar(Algomon enemigo, Movimiento movimiento) {
        try{
        	this.estadoEfimero.consecuencia(this); 
        	this.estadoPermanente.consecuencia(this);
        	
        	if (movimiento == Movimiento.CHUPAVIDAS) {	// este IF se va con el cambio de implementación de CHUPAVIDAS
        		int danioCausado = this.ataques.get(movimiento).efectuar(enemigo);
        		int cantidadDeDanioARecuperar = (danioCausado*30/100);
        		this.vida += cantidadDeDanioARecuperar;
        	}else{
        		this.ataques.get(movimiento).efectuar(enemigo);		// queda esto solo
        	}
        	
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

    public void recuperarEstadoEfimero() {
       this.estadoEfimero = new EstadoDeAlgomonNormal();
    }

    public void cambiarEstadoEfimero(EstadoDeAlgomon nuevoEstado) {
        this.estadoEfimero = nuevoEstado;
    }
    
    public void cambiarEstadoPermanente(EstadoDeAlgomon nuevoEstado) {
        this.estadoPermanente = nuevoEstado;
    }

    public void turnoTerminado() {
        this.estadoEfimero.turnoTerminado(this);
    }

    public void causarDanio(int potencia) {
        this.estadoEfimero.causarDanio(potencia, this);
    }
}
