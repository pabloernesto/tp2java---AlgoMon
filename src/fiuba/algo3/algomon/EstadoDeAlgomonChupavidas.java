package fiuba.algo3.algomon;

public class EstadoDeAlgomonChupavidas implements EstadoDeAlgomon {

    int cantidadDeDanioARecuperar;
    @Override
    public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo) {
        int danioCausado = ataqueNormal.efectuar(enemigo);
        this.cantidadDeDanioARecuperar = (danioCausado*30/100);
        return this;
    }

    @Override
    public void turnoTerminado(Algomon algoMon) {
        algoMon.vida += this.cantidadDeDanioARecuperar;
        algoMon.recuperarEstado();
    }

    @Override
    public void causarDanio(int potencia, Algomon algoMon) {
        algoMon.vida -= potencia;
    }

    @Override
    public void estadoDelAtacante(Ataque ataqueNormal, Algomon algoMon) {
       algoMon.estado(ataqueNormal.estadoDelAlgomonAtacante(ataqueNormal));
    }

}
