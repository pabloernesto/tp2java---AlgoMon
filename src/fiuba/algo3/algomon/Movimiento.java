package fiuba.algo3.algomon;

public enum Movimiento
{
    BURBUJAS(10), CANION_DE_AGUA(20), LATIGO_CEPA(60);

    int potencia;

    Movimiento(int potencia)
    {
        this.potencia = potencia;
    }

    public int potencia(Tipo t)
    {
        if (t == Tipo.AGUA)
            return potencia / 2;

        if (t == Tipo.FUEGO)
            return potencia * 2;

        if (t == Tipo.PLANTA)
            return potencia / 2;

        return potencia;
    }
}
