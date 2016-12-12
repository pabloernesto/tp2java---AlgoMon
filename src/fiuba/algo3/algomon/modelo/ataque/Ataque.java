package fiuba.algo3.algomon.modelo.ataque;
import  fiuba.algo3.algomon.excepciones.*;
import fiuba.algo3.algomon.modelo.Algomon;
import fiuba.algo3.algomon.modelo.Movimiento;

public class Ataque
{
    int cantidadDeUsosRestantes;
    Movimiento movimiento;

    public Ataque(Movimiento mov) {
        this.movimiento = mov;
        cantidadDeUsosRestantes = this.movimiento.getCantidadDeUsos();
    }

    public Movimiento movimiento() {
        return movimiento;
    }

    public int efectuar(Algomon atacado) {
        this.descontarUso();
        int cantidadDeDanioCausado = movimiento.potencia(atacado.getTipo());
        atacado.causarDanio(cantidadDeDanioCausado);
        return cantidadDeDanioCausado;
    }

    protected void descontarUso(){
         if (cantidadDeUsosRestantes == 0)
            throw new CantidadDeAtaquesExcedidaException();
        cantidadDeUsosRestantes--;
    }

    public void setAtacante(Algomon atacante) {
    }

    public void recuperarUsos(int cantidadDeUsosARecuperar) {
        cantidadDeUsosRestantes += cantidadDeUsosARecuperar;
        if(cantidadDeUsosRestantes > movimiento.getCantidadDeUsos()) {
            cantidadDeUsosRestantes = movimiento.getCantidadDeUsos();
        }
    }

	public int cantidadDeUsosRestantes() {
		return cantidadDeUsosRestantes;
	}
}
