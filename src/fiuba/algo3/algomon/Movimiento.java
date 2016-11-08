package fiuba.algo3.algomon;

public enum Movimiento
{
    BURBUJAS(Tipo.AGUA, 10),
    CANION_DE_AGUA(Tipo.AGUA, 20),
    LATIGO_CEPA(Tipo.PLANTA, 15),
    BRASAS(Tipo.FUEGO, 16),
    ATAQUE_RAPIDO(Tipo.NORMAL, 10);

    int potencia;
    Tipo tipo;

    Movimiento(Tipo tipo, int potencia)
    {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public int potencia(Tipo t)
    {
        return (int) (potencia * tipo.efectividad(t));
    }
}
