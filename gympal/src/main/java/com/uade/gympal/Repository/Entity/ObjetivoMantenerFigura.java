package com.uade.gympal.Repository.Entity;

import com.uade.gympal.Service.RutinaService;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ObjetivoMantenerFigura extends Objetivo {
    private float variacionPeso;
    private float pesoInicial;

    @Override
    public boolean objetivoCumplido(Socio socio) {
        float peso = socio.getPeso();
        // boolean rutinaCompletada = rutinaService.verificarCompleto(socio).isCompletada();
        return peso >= (pesoInicial - variacionPeso) && peso <= (pesoInicial + variacionPeso);
    }
}
