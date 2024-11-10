package com.uade.gympal.Repository.SistemaNotificador;

public class Notificador {
    private IEstrategiaNotificacion estrategia;

    public void notificar(Notificacion notificacion) {}

    public IEstrategiaNotificacion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(IEstrategiaNotificacion estrategia) {
        this.estrategia = estrategia;
    }
}
