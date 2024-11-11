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
public class ObjetivoBajarPeso extends Objetivo{

    private float pesoIdeal;

    @Override
    public boolean objetivoCumplido(Socio socio) {
        return socio.getPeso() <= pesoIdeal;
    }
}
