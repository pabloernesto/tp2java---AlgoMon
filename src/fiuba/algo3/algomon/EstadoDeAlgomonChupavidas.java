package fiuba.algo3.algomon;

public class EstadoDeAlgomonChupavidas implements EstadoDeAlgomon {

    int cantidadDeDanioARecuperar;
    //@Override
    //public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo) {
    //    int danioCausado = ataqueNormal.efectuar(enemigo);
    //    this.cantidadDeDanioARecuperar = (danioCausado*30/100);
    //    return this;
    //}

    @Override
    public void turnoTerminado(Algomon algoMon) {
        algoMon.vida += this.cantidadDeDanioARecuperar;
        algoMon.recuperarEstadoEfimero();
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataque, Algomon algoMon) {
       algoMon.cambiarEstadoEfimero(ataque.estadoDelAlgomonAtacante(ataque));
    }

	@Override
	public void consecuencia(Algomon algomon) {

        algomon.recuperarEstadoEfimero();
		
	}

}
