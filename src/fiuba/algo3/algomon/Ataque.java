package fiuba.algo3.algomon;
import  fiuba.algo3.algomon.excepciones.*;

public class Ataque
{
    int cantidadDeUsosRestantes;
    Movimiento movimiento;

    public Ataque(Movimiento m)
    {
        movimiento = m;
        cantidadDeUsosRestantes = m.cantidadDeUsos;
    }

    public Ataque atacar(AlgoMon atacado)
    {
        if (--cantidadDeUsosRestantes < 0)
            throw new CantidadDeAtaquesExcedidaException();

        atacado.vida -= movimiento.potencia(atacado.tipo);
        return this;
    }
}
