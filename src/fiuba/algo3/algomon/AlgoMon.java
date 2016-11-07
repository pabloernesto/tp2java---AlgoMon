package fiuba.algo3.algomon;

public class AlgoMon
{
    int vida = 100;

    public AlgoMon atacar(AlgoMon enemigo, Movimiento movimiento)
    {
        enemigo.vida -= 20;
        return this;
    }

    public int vida()
    {
        return vida;
    }
}
