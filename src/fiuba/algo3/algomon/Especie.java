package fiuba.algo3.algomon;

public enum Especie
{
    SQUIRTLE
    {   
        public AlgoMon nuevo()
        {
            return new AlgoMon();
        }
    },

    CHARMANDER
    {   
        public AlgoMon nuevo()
        {
            return new AlgoMon();
        }
    };

    public abstract AlgoMon nuevo();
}
