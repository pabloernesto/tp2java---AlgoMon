package fiuba.algo3.algomon;

public interface EstadoDeAlgomon {

    public void turnoTerminado(Algomon algoMon);

    public void causarDanio(int potencia, Algomon algoMon);

    public void estadoDelAtacante(Ataque ataqueNormal, Algomon algoMon);

	public void consecuencia(Algomon algomon);

}
