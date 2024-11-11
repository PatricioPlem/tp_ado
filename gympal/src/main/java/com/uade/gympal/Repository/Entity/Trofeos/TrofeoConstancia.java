package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Rutina;
import com.uade.gympal.Repository.Entity.Socio;

public class TrofeoConstancia extends Trofeo {
    public TrofeoConstancia() {
        super("Trofeo Constancia");
    }

    public boolean verificarCumplimiento(Rutina rutina) {
        return true;
    }

    @Override
    public void serNotificado(Socio socio) {
        System.out.println("Trofeo a la Constancia");
        socio.agregarTrofeo(this);
    }
}
