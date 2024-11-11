package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.SistemaNotificador.Notificacion;
import com.uade.gympal.Repository.SistemaNotificador.SistemaNotificador;

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

        Notificacion notificacion = new Notificacion();
        notificacion.setTitulo("¡Trofeo adquirido!");
        notificacion.setCuerpo("Completaste tu objetivo.");
        notificacion.setIcono("icono_dedicacion.png");

        SistemaNotificador.getInstancia().notificar(notificacion);

        socio.agregarTrofeo(this);
    }
}
