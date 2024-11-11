package com.uade.gympal.Repository.SistemaNotificador;

import com.uade.gympal.Repository.SistemaNotificador.Firebase.NotificacionFirebase;

public class SistemaNotificador {
    private static SistemaNotificador instancia;
    private Notificador notificador;

    private SistemaNotificador() {
        this.notificador = new Notificador();
        this.notificador.setEstrategia(new NotificacionFirebase());
    }

    public static SistemaNotificador getInstancia() {
        if (instancia == null) {
            instancia = new SistemaNotificador();
        }
        return instancia;
    }

    public void notificar(Notificacion notificacion) {
        notificador.notificar(notificacion);
    }
}
