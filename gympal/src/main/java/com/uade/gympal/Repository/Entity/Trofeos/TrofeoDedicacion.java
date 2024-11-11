package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.Entity.Socio;

public class TrofeoDedicacion extends Trofeo {
    public TrofeoDedicacion() {
        super("Trofeo Dedicación");
    }

    public boolean verificarCumplimiento(Objetivo objetivo) {
        return true;
    }

    @Override
    public void serNotificado(Socio socio) {
        System.out.println("Trofeo a la Dedicación");
        socio.agregarTrofeo(this);
    }
}
