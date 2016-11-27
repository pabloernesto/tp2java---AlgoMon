package fiuba.algo3.algomon.modelo;

import fiuba.algo3.algomon.modelo.ataque.Ataque;
import fiuba.algo3.algomon.modelo.ataque.AtaqueCanto;
import fiuba.algo3.algomon.modelo.ataque.AtaqueChupavidas;
import fiuba.algo3.algomon.modelo.ataque.AtaqueFogonazo;

public enum Movimiento
{
    // NOMBRE_ATAQUE(tipo,potencia,cantidadDeUsos)
    ATAQUE_RAPIDO(Tipo.NORMAL, 10, 16),
    BURBUJA(Tipo.AGUA, 10, 15),
    CANION_DE_AGUA(Tipo.AGUA, 20, 8),
    LATIGO_CEPA(Tipo.PLANTA, 15, 10),
    BRASAS(Tipo.FUEGO, 16, 10),

    CHUPAVIDAS(Tipo.PLANTA, 15, 8) {
        public Ataque nuevo() {
            return (new AtaqueChupavidas(this));
        }
    },

    FOGONAZO(Tipo.FUEGO, 2,4) {
        public Ataque nuevo() {
            return (new AtaqueFogonazo(this));
        }
    },

    CANTO(Tipo.NORMAL, 0, 6) {
        public Ataque nuevo() {
            return (new AtaqueCanto(this));
        }
    };

    int potencia;
    private int cantidadDeUsos;
    Tipo tipo;

    Movimiento(Tipo tipo, int potencia, int cantidadDeUsos) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.setCantidadDeUsos(cantidadDeUsos);
    }

    public int potencia(Tipo t) {
        int cantidadTotal = (int)(potencia * tipo.efectividad(t));
        return cantidadTotal;
    }

    public Ataque nuevo() {
        return (new Ataque(this));
    }

	public int getCantidadDeUsos() {
		return cantidadDeUsos;
	}

	public void setCantidadDeUsos(int cantidadDeUsos) {
		this.cantidadDeUsos = cantidadDeUsos;
	}
}
