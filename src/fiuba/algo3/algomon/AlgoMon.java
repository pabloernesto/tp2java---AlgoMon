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
        if (movimiento == Movimiento.FOGONAZO)
            throw new RuntimeException();

        enemigo.vida -= movimiento.potencia(enemigo.tipo);

        return this;
    }

    public int vida()
    {
        return vida;
    }
}
