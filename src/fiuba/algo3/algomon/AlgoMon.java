package fiuba.algo3.algomon;

public class AlgoMon
{
    int vida = 100;

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
        if (movimiento == Movimiento.BURBUJAS)
            enemigo.vida -= 20;
        else
            enemigo.vida -= 40;

        return this;
    }

    public int vida()
    {
        return vida;
    }
}
