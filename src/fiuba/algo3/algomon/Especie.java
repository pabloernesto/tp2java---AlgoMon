package fiuba.algo3.algomon;

public enum Especie
{
    SQUIRTLE
    {   
        public AlgoMon nuevo()
        {
            return new AlgoMon(Tipo.AGUA);
        }
    },

    CHARMANDER
    {   
        public AlgoMon nuevo()
        {
            return new AlgoMon(Tipo.FUEGO);
        }
    },
    
    BULBASAUR
    {
        public AlgoMon nuevo()
        {
            return new AlgoMon(Tipo.PLANTA);
        }
    },

    RATTATA
    {
        public AlgoMon nuevo()
        {
            return new AlgoMon(Tipo.NORMAL);
        }
    },

    CHANSEY
    {
        public AlgoMon nuevo()
        {
            return new AlgoMon(Tipo.NORMAL);
        }
    };

    public abstract AlgoMon nuevo();
}
