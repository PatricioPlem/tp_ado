package com.uade.gympal.Repository.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.uade.gympal.Repository.Entity.Observer.IObservable;
import com.uade.gympal.Repository.Entity.Observer.Observador;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoConstancia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Observer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rutina implements IObservable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Entrenamiento> entrenamientos;

    @Transient
    private List<Observador> observers;

    public boolean esPerfecta() {
        for (Entrenamiento entrenamiento : entrenamientos) {
            if (!entrenamiento.isCompletado()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void agregar(Observador observador) {
        observers.add(observador);
    }

    @Override
    public void eliminar(Observador observador) {
        observers.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observers) {
            if (observador instanceof TrofeoConstancia) {
                observador.serNotificado(CurrentUserHolder.getCurrentUser());
            }
        }
    }
}