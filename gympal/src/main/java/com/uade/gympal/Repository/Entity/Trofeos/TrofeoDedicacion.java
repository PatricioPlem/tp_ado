package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Objetivo;

public class TrofeoDedicacion extends Trofeo {
    public TrofeoDedicacion() {
        super("Trofeo Dedicación");
    }

    public boolean verificarCumplimiento(Objetivo objetivo) {
        return true;
    }

    @Override
    public void serNotificado() {}
}
