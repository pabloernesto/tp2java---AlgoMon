package fiuba.algo3.algomon.modelo;

public enum Especie
{
    SQUIRTLE	(Tipo.AGUA,   new Movimiento[] { Movimiento.BURBUJA, Movimiento.CANION_DE_AGUA, Movimiento.ATAQUE_RAPIDO }, 150),
    CHARMANDER	(Tipo.FUEGO,  new Movimiento[] { Movimiento.BRASAS, Movimiento.FOGONAZO, Movimiento.ATAQUE_RAPIDO }, 170),
    BULBASAUR	(Tipo.PLANTA, new Movimiento[] { Movimiento.CHUPAVIDAS, Movimiento.LATIGO_CEPA, Movimiento.ATAQUE_RAPIDO }, 140),
    RATTATA		(Tipo.NORMAL, new Movimiento[] { Movimiento.FOGONAZO, Movimiento.BURBUJA, Movimiento.ATAQUE_RAPIDO }, 170),
    CHANSEY		(Tipo.NORMAL, new Movimiento[] { Movimiento.CANTO, Movimiento.LATIGO_CEPA, Movimiento.ATAQUE_RAPIDO }, 130),
    JIGGLYPUFF	(Tipo.NORMAL, new Movimiento[] { Movimiento.CANTO, Movimiento.BURBUJA, Movimiento.ATAQUE_RAPIDO }, 130);

    Movimiento[] movimientos;
    Tipo tipo;
    int vida;

    Especie(Tipo t, Movimiento[] m, int v) {
        this.tipo = t;
        this.movimientos = m;
        this.vida = v;
    }

    public Algomon nuevo() {
        return new Algomon(tipo, movimientos, vida);
    }
}
