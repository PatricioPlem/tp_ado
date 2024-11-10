package com.uade.gympal.Repository.SistemaNotificador;

public class SistemaNotificador {
    private SistemaNotificador instancia;
    private Notificador notificador;
//    private List<IObservable> observables;

    public SistemaNotificador getInstancia() {
        return this;
    }

//    public agregarObservable(ObservableTrofeo observable) {}
//    public eliminarObservable(ObservableTrofeo observable) {}
    public void notificar(Notificacion notificacion) {}
}
