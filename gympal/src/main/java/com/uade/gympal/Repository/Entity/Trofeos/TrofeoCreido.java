package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Medicion;

public class TrofeoCreido extends Trofeo {
    public TrofeoCreido() {
        super("Trofeo Creído");
    }

    public boolean verificarCumplimiento(Medicion medicion) {
        return true;
    }

    @Override
    public void serNotificado() {}
}
