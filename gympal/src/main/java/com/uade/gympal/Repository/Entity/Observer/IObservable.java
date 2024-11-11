package com.uade.gympal.Repository.Entity.Observer;

public interface IObservable {
    void agregar(Observador observador);
    void eliminar(Observador observador);
    void notificarObservadores();
}
