package fiuba.algo3.algomon;

public enum Especie
{
    SQUIRTLE(
        Tipo.AGUA,
        new Movimiento[]
        {
            Movimiento.BURBUJAS,
            Movimiento.CANION_DE_AGUA,
            Movimiento.ATAQUE_RAPIDO
        }),
    CHARMANDER(
        Tipo.FUEGO,
        new Movimiento[]
        {
            Movimiento.BRASAS,
            Movimiento.FOGONAZO,
            Movimiento.ATAQUE_RAPIDO
        }),
    BULBASAUR(
        Tipo.PLANTA,
        new Movimiento[]
        {
            Movimiento.LATIGO_CEPA,
            Movimiento.ATAQUE_RAPIDO
        }),
    RATTATA(
        Tipo.NORMAL,
        new Movimiento[]
        {
            Movimiento.FOGONAZO,
            Movimiento.BURBUJAS,
            Movimiento.ATAQUE_RAPIDO
        }),
    CHANSEY(
        Tipo.NORMAL,
        new Movimiento[]
        {
            Movimiento.LATIGO_CEPA,
            Movimiento.ATAQUE_RAPIDO
        });

    Movimiento[] movimientos;
    Tipo tipo;

    Especie(Tipo t, Movimiento[] m)
    {
        tipo = t;
        movimientos = m;
    }

    public AlgoMon nuevo()
    {
        return new AlgoMon(tipo, movimientos);
    }
}
