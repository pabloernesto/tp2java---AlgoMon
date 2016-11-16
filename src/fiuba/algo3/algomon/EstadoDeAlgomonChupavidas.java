package fiuba.algo3.algomon;

public class EstadoDeAlgomonChupavidas implements EstadoDeAlgomon {

    int cantidadDeDanioARecuperar;
    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, AlgoMon enemigo) {
        int danioCausado = ataqueNormal.atacar(enemigo);
        this.cantidadDeDanioARecuperar = (danioCausado*30/100);
        return this;
    }

    @Override
    public void turnoTerminado(AlgoMon algoMon) {
        algoMon.vida += this.cantidadDeDanioARecuperar;
        algoMon.recuperarEstado();
    }

    @Override
    public void causarDanio(int potencia, AlgoMon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, AlgoMon algoMon) {
       algoMon.estado(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

}
