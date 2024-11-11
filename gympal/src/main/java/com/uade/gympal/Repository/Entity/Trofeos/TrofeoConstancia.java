package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Rutina;

public class TrofeoConstancia extends Trofeo {
    public TrofeoConstancia() {
        super("Trofeo Constancia");
    }

    public boolean verificarCumplimiento(Rutina rutina) {
        return true;
    }

    @Override
    public void serNotificado() {}
}
