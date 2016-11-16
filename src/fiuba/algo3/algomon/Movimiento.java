package fiuba.algo3.algomon;

public enum Movimiento
{
	// NOMBRE_ATAQUE(tipo,potencia,cantidadDeUsos)
    ATAQUE_RAPIDO(Tipo.NORMAL, 10, 16),
    CANTO(Tipo.NORMAL, 0, 6),
    BURBUJA(Tipo.AGUA, 10, 15),
    CANION_DE_AGUA(Tipo.AGUA, 20, 8),
    CHUPAVIDAS(Tipo.PLANTA, 15, 8),
    LATIGO_CEPA(Tipo.PLANTA, 15, 10),
    BRASAS(Tipo.FUEGO, 16, 10),
    FOGONAZO(Tipo.FUEGO, 2,4);

    int potencia;
    int cantidadDeUsos;
    Tipo tipo;

    Movimiento(Tipo tipo, int potencia, int cantidadDeUsos) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.cantidadDeUsos =cantidadDeUsos;
    }

    public int potencia(Tipo t) {
        int cantidadTotal = (int)(potencia * tipo.efectividad(t));
        return cantidadTotal;
    }
    
    public EstadoDeAlgomon efectoEfimero() {// ! refactor 
		if (this == CANTO) 			
			return new EstadoDeAlgomonDormido();
		else
			return new EstadoDeAlgomonNormal();
    }

    public EstadoDeAlgomon estadoDelAlgomonAtacante(){// ! refactor 
 		if (this == Movimiento.CHUPAVIDAS) 			
			return new EstadoDeAlgomonChupavidas();
		else
			return new EstadoDeAlgomonNormal();
        
    }
}
