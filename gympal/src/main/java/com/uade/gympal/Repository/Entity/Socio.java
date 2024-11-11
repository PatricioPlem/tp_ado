package com.uade.gympal.Repository.Entity;

import com.uade.gympal.Repository.Entity.Observer.IObservable;
import com.uade.gympal.Repository.Entity.Observer.Observador;
import com.uade.gympal.Repository.Entity.Trofeos.Trofeo;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoCreido;
import com.uade.gympal.Repository.Enums.SexoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio implements IObservable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int edad;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    private float peso;

    private int altura;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Objetivo objetivo;

    //@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    //private List<Trofeo> trofeos;

    private float masaMuscular;

    private float grasaCorporal;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Trofeo> trofeos;

    @Transient
    private List<Observador> observers;

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
        for (Observador observador: observers) {
            observador.serNotificado();
        }
    }

    public void notificarTrofeoCreido() {
        for(Observador observador: observers) {
            if (observador instanceof TrofeoCreido) {
                observador.serNotificado();
            }
        }
    }
}
