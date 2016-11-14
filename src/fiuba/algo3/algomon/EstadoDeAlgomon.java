package fiuba.algo3.algomon;

public interface EstadoDeAlgomon {

    public EstadoDeAlgomon atacar(AtaqueNormal ataqueNormal, AlgoMon enemigo);
    public void turnoTerminado(AlgoMon algoMon);
}
