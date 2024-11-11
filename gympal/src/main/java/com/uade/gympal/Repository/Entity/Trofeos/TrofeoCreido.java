package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Medicion;
import com.uade.gympal.Repository.Entity.Socio;

public class TrofeoCreido extends Trofeo {
    public TrofeoCreido() {
        super("Trofeo Creído");
    }

    public boolean verificarCumplimiento(Medicion medicion) {
        return true;
    }

    @Override
    public void serNotificado(Socio socio) {
        System.out.println("Trofeo al Creído");
        socio.agregarTrofeo(this);
    }
}
