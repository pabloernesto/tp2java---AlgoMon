package fiuba.algo3.algomon;
import  fiuba.algo3.algomon.excepciones.*;

public class Ataque
{
    int cantidadDeUsosRestantes;
    Movimiento movimiento;


    public Ataque(){};

    public Ataque(Movimiento mov) {
        this.movimiento = mov;
        cantidadDeUsosRestantes = this.movimiento.cantidadDeUsos;
    }

    public int atacar(AlgoMon atacado) {
        if (cantidadDeUsosRestantes == 0)
            throw new CantidadDeAtaquesExcedidaException();

        cantidadDeUsosRestantes--;

        int cantidadDeDanioCausado = movimiento.potencia(atacado.tipo);
        atacado.causarDanio(cantidadDeDanioCausado);

        atacado.estado(movimiento.efectoEfimero());
        //atacado.manejoDeEstado(movimiento.efectoEfimero());

        return cantidadDeDanioCausado;
    }

    public EstadoDeAlgomon estadoDelAlgomonAtacante(Ataque ataqueNormal) {
        return movimiento.estadoDelAlgomonAtacante();
    }
}
