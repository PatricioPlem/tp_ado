package com.uade.gympal.Repository.Entity;


import com.uade.gympal.Repository.Enums.ExigenciaMuscularEnum;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
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
public class EjercicioTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int nivelAerobico;
    @Enumerated(EnumType.STRING)
    private ExigenciaMuscularEnum exigenciaMuscular;
    @OneToOne
    private VideoFile video;
    private boolean completado;
    @Enumerated(EnumType.STRING)
    private GrupoMuscularEnum grupoMuscular;  // Cambiado a Enum
    private int series;
    private int repeticiones;
    private float peso;



}