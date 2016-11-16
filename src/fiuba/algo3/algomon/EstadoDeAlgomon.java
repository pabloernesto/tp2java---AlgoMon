package fiuba.algo3.algomon;

public interface EstadoDeAlgomon {

    public EstadoDeAlgomon atacar(Ataque ataqueNormal, AlgoMon enemigo);

    public void turnoTerminado(AlgoMon algoMon);

    public void causarDanio(int potencia, AlgoMon algoMon);

    public void estadoDelAtacante(Ataque ataqueNormal, AlgoMon algoMon);
}
