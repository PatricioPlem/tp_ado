package com.uade.gympal.Repository.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrenamiento> entrenamientos;

    private boolean completada;

    @OneToOne(cascade = CascadeType.ALL)
    private Objetivo objetivo;

    public boolean esPerfecta() {
        for (Entrenamiento entrenamiento : entrenamientos) {
            if (!entrenamiento.isCompletado()) {
                return false;
            }
        }
        return true;
    }
}