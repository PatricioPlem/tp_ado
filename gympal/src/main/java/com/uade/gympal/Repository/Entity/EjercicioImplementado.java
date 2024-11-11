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
    @OneToOne
    @JsonIgnore
    private Entrenamiento entrenamiento;
    @OneToOne
    @JsonManagedReference
    private EjercicioTemplate ejercicioTemplate;
    private float peso;
    private int series;
    private int repeticiones;
    private float pesoUsado;
    private int seriesRealizadas;
    private int repeticionesRealizadas;
    private boolean completado;



}
