package com.uade.gympal.Repository.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class EjercicioImplementado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Entrenamiento entrenamiento;
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    private VideoFile video;
    private float peso;
    private int series;
    private int repeticiones;
    private float pesoUsado;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private boolean completado;



}
