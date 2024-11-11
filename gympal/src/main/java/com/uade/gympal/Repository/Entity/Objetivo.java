package com.uade.gympal.Repository.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.uade.gympal.Repository.Entity.Observer.IObservable;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Repository.Entity.Observer.Observador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // o InheritanceType.JOINED, según el tipo de herencia que necesites

public abstract class Objetivo implements IObservable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Rutina rutina;
    @Enumerated(EnumType.STRING)
    private ObjetivoEnum tipo;

    @Transient
    private List<Observador> observers = new ArrayList<>();

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
            observador.serNotificado();
        }
    }

    public abstract boolean objetivoCumplido(Socio socio);

    public void notifyIfNeeded(Socio socio) {
        if (objetivoCumplido(socio)) {
            notificarObservadores();
        }
    }
}
