package fiuba.algo3.algomon.modelo;

public enum Tipo
{
      AGUA(new double[]{0.5, 2.0, 0.5, 1.0}),
     FUEGO(new double[]{0.5, 0.5, 2.0, 1.0}),
    PLANTA(new double[]{2.0, 0.5, 0.5, 1.0}),
    NORMAL(new double[]{1.0, 1.0, 1.0, 1.0});

    // efectividades contra, en este orden: AGUA, FUEGO, PLANTA, y NORMAL
    double[] efectividades;

    Tipo(double[] efectividades)
    {
        this.efectividades = efectividades;
    }

    public double efectividad(Tipo t)
    {
        return efectividades[t.ordinal()];
    }
}
