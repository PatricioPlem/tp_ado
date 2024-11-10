package com.uade.gympal.Repository.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.uade.gympal.Repository.Enums.ExigenciaMuscular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;
    @OneToOne
    private VideoFile video;
    private boolean completado;
    @ManyToOne
    @JsonBackReference
    private GrupoMuscular grupoMuscular;
    private int series;
    private int repeticiones;
    private double peso;
}