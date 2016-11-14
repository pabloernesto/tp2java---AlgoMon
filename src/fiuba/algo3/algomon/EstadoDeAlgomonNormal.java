package fiuba.algo3.algomon;

import java.util.EnumMap;
import java.util.Map;

import fiuba.algo3.algomon.excepciones.AlgomonNoPoseeElMovimientoException;

public class EstadoDeAlgomonNormal implements EstadoDeAlgomon {

    Map<Movimiento, AtaqueNormal> ataques = new EnumMap<Movimiento, AtaqueNormal>(Movimiento.class);

    public EstadoDeAlgomonNormal() {
    }

    @Override
    public void turnoTerminado(AlgoMon algomon) {
    }

    @Override
    public EstadoDeAlgomon atacar(AtaqueNormal ataqueNormal, AlgoMon enemigo) {
 
//        if (turnosRestantesDormido != 0)
//            throw new AlgomonEstaInhabilitadoParaAtacarException();
        
        ataqueNormal.atacar(enemigo);
        return this;
    }

}
