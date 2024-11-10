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
public class ObjetivoMantenerFigura extends Objetivo{
    private float variacionPeso;
    private float pesoInicial;
}
