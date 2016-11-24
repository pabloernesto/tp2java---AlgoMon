package fiuba.algo3.algomon.modelo;
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

        int cantidadDeDanioCausado = movimiento.potencia(atacado.tipo);
        atacado.causarDanio(cantidadDeDanioCausado);
        return cantidadDeDanioCausado;
    }

    public void setAtacante(Algomon atacante) {
    }

    public void recuperarUsos(int cantidadDeUsosARecuperar) {
        cantidadDeUsosRestantes += cantidadDeUsosARecuperar;
        if(cantidadDeUsosRestantes > movimiento.cantidadDeUsos) {
            cantidadDeUsosRestantes = movimiento.cantidadDeUsos;
        }
        
    }
}
