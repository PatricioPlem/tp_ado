package com.uade.gympal.Repository.Entity;

import com.uade.gympal.Repository.Enums.TipoObjetivo;
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
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Rutina rutina;

    //public Objetivo cambiarObjetivo(TipoObjetivo tipoObjetivo) {

    //}

}