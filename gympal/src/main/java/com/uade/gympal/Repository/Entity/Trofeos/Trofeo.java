package com.uade.gympal.Repository.Entity.Trofeos;

import com.uade.gympal.Repository.Entity.Observer.Observador;
import com.uade.gympal.Repository.Entity.Socio;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // o InheritanceType.JOINED, según el tipo de herencia que necesites

public abstract class Trofeo implements Observador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Trofeo(String name) {
        this.name = name;
    }

    public abstract void serNotificado(Socio socio);
}
