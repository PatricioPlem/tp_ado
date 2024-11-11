package com.uade.gympal.Repository.SistemaNotificador;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notificador {
    private IEstrategiaNotificacion estrategia;

    public void notificar(Notificacion notificacion) {
        if (estrategia != null) {
            estrategia.enviar(notificacion);
        }
    }
}
