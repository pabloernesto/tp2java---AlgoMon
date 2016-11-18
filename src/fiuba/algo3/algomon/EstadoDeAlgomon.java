package fiuba.algo3.algomon;

public interface EstadoDeAlgomon {

    public EstadoDeAlgomon atacar(Ataque ataqueNormal, Algomon enemigo);

    public void turnoTerminado(Algomon algoMon);

    public void causarDanio(int potencia, Algomon algoMon);
}
