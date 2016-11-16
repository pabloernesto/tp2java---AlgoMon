package fiuba.algo3.algomon;

public interface EstadoDeAlgomon {

    public EstadoDeAlgomon atacar(AtaqueNormal ataqueNormal, AlgoMon enemigo);
    
    public void turnoTerminado(AlgoMon algoMon);

    public void causarDanio(int potencia, AlgoMon algoMon);

    public void estadoDelAtacante(AtaqueNormal ataqueNormal, AlgoMon algoMon);
}
