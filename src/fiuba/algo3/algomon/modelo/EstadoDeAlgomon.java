package fiuba.algo3.algomon.modelo;

public interface EstadoDeAlgomon {

    public void turnoTerminado(Algomon algoMon);

    public void causarDanio(int potencia, Algomon algoMon);

    public void consecuencia(Algomon algomon);
}
