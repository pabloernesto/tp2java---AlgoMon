package fiuba.algo3.algomon;

public class AlgoMon
{
    int vida = 100;
    Tipo tipo;

    public AlgoMon(Tipo t)
    {
        tipo = t;
    }

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
        if (movimiento == Movimiento.BURBUJAS)
            if (enemigo.tipo == Tipo.FUEGO)
                enemigo.vida -= 20;
            else
                enemigo.vida -= 5;
        else
            enemigo.vida -= 40;

        return this;
    }

    public int vida()
    {
        return vida;
    }
}
