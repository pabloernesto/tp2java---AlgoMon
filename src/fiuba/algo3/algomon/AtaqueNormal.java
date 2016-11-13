package fiuba.algo3.algomon;
import  fiuba.algo3.algomon.excepciones.*;

public class AtaqueNormal implements Ataque
{
    int cantidadDeUsosRestantes;
    Movimiento movimiento;

    public AtaqueNormal(){};
    public AtaqueNormal(Movimiento m)
    {
        movimiento = m;
        cantidadDeUsosRestantes = m.cantidadDeUsos;
    }

    public AtaqueNormal atacar(AlgoMon atacado)
    {
        if (cantidadDeUsosRestantes == 0)
            throw new CantidadDeAtaquesExcedidaException();

        cantidadDeUsosRestantes--;
        atacado.vida -= movimiento.potencia(atacado.tipo);
        atacado.turnosRestantesDormido = movimiento.efectoEfimero();
        //atacado.manejoDeEstado(movimiento.efectoEfimero());
        
        return this;
    }
}
