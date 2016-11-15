package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

public class EstadoDeAlgomonNormal implements EstadoDeAlgomon {

    Map<Movimiento, AtaqueNormal> ataques = new EnumMap<Movimiento, AtaqueNormal>(Movimiento.class);

    public EstadoDeAlgomonNormal() {
    }

    @Override
    public void turnoTerminado(AlgoMon algomon) {
    }

    @Override
    public EstadoDeAlgomon atacar(AtaqueNormal ataqueNormal, AlgoMon enemigo) {       
        ataqueNormal.atacar(enemigo);
        return this;
    }

}
