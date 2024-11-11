package com.uade.gympal.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RutinaCompletadaDTO {

    private Long rutinaId;
    private String socioName;
    private boolean completada;

}
