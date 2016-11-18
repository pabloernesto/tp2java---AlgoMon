package fiuba.algo3.algomon;
import  fiuba.algo3.algomon.excepciones.*;

public class Ataque
{
    int cantidadDeUsosRestantes;
    Movimiento movimiento;

    public Ataque(Movimiento mov) {
        this.movimiento = mov;
        cantidadDeUsosRestantes = this.movimiento.cantidadDeUsos;
    }

    public int efectuar(Algomon atacado) {
        if (cantidadDeUsosRestantes == 0)
            throw new CantidadDeAtaquesExcedidaException();

        cantidadDeUsosRestantes--;

        atacado.cambiarEstadoEfimero(movimiento.tipoDeEfecto());

        int cantidadDeDanioCausado = movimiento.potencia(atacado.tipo);
        atacado.causarDanio(cantidadDeDanioCausado);
        return cantidadDeDanioCausado;
    }

    public EstadoDeAlgomon estadoDelAlgomonAtacante(Ataque ataqueNormal) {
        return movimiento.estadoDelAlgomonAtacante();
    }
}
