package com.uade.gympal.Repository.Entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ObjetivoTonificar extends Objetivo{
    private float IMC;
    private float porcentajeGrasa;
}
