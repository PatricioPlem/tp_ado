package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Rutina;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.SistemaNotificador.Notificacion;
import com.uade.gympal.Repository.SistemaNotificador.SistemaNotificador;

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

        Notificacion notificacion = new Notificacion();
        notificacion.setTitulo("¡Trofeo adquirido!");
        notificacion.setCuerpo("Completaste a la perfección tu rutina.");
        notificacion.setIcono("icono_constancia.png");

        SistemaNotificador.getInstancia().notificar(notificacion);

        socio.agregarTrofeo(this);
    }
}
