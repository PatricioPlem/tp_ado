package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Medicion;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.SistemaNotificador.Notificacion;
import com.uade.gympal.Repository.SistemaNotificador.SistemaNotificador;

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

        Notificacion notificacion = new Notificacion();
        notificacion.setTitulo("¡Trofeo adquirido!");
        notificacion.setCuerpo("Te pesaste 3 veces en el mismo mes.");
        notificacion.setIcono("icono_creido.png");

        SistemaNotificador.getInstancia().notificar(notificacion);

        socio.agregarTrofeo(this);
    }
}
