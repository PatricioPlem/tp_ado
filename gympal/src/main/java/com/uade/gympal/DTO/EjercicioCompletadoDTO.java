package com.uade.gympal.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioCompletadoDTO {

    private Long id;
    private float peso;
    private int series;
    private int repeticiones;

}
