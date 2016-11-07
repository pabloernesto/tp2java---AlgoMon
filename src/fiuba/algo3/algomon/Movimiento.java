package fiuba.algo3.algomon;

public enum Movimiento
{
    BURBUJAS(10), CANION_DE_AGUA(20);

    int potencia;

    Movimiento(int potencia)
    {
        this.potencia = potencia;
    }

    public int potencia(Tipo t)
    {
        return t == Tipo.FUEGO ? potencia * 2 : potencia / 2;
    }
}
