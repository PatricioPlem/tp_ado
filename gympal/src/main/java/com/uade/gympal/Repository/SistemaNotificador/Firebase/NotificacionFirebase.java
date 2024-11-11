package com.uade.gympal.Repository.SistemaNotificador.Firebase;

import com.uade.gympal.Repository.SistemaNotificador.IEstrategiaNotificacion;
import com.uade.gympal.Repository.SistemaNotificador.Notificacion;

public class NotificacionFirebase implements IEstrategiaNotificacion {
    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando notificación vía Firebase:");
        System.out.println("Título: " + notificacion.getTitulo());
        System.out.println("Cuerpo: " + notificacion.getCuerpo());
        System.out.println("Icono: " + notificacion.getIcono());
    }
}
