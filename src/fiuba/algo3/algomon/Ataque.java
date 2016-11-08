package fiuba.algo3.algomon;

public class Ataque
{
    int cantidadRestante = 4;
    Movimiento movimiento;

    public Ataque(Movimiento m)
    {
        movimiento = m;
    }

    public Ataque atacar(AlgoMon atacado)
    {
        if (--cantidadRestante < 0)
            throw new RuntimeException();

        atacado.vida -= movimiento.potencia(atacado.tipo);
        return this;
    }
}
