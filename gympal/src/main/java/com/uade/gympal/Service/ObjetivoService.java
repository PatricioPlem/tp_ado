package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.*;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoService {
    @Autowired
    private ObjetivoRepository objetivoRepository;
    @Autowired
    private RutinaFactory rutinaFactory;
    @Autowired
    private RutinaService rutinaService;


    public Objetivo getUserObjetivo(Socio socioAutenticado) {
                return socioAutenticado.getObjetivo();
    }

    // Método para crear un nuevo objetivo
    public Objetivo createObjetivo(ObjetivoEnum objetivo) {

        Rutina rutina = rutinaFactory.generarRutina(objetivo);

        switch (objetivo) {
            case BAJAR_PESO:
                return ObjetivoBajarPeso.builder()
                        .pesoIdeal(60) // Aquí podrías obtener el valor real de algún dato de la entidad `objetivo`
                        .tipo(objetivo)
                        .rutina(rutina)
                        .build();

            case TONIFICAR:
                return ObjetivoTonificar.builder()
                        .IMC(20) // Asegúrate de que `objetivo` tenga el valor de IMC
                        .porcentajeGrasa(12)
                        .tipo(objetivo)
                        .rutina(rutina)
                        .build();

            case MANTENER_FIGURA:
                return ObjetivoMantenerFigura.builder()
                        .tipo(objetivo)
                        .rutina(rutina)
                        .pesoInicial(70)
                        .variacionPeso(2.5F)
                        .build();

        }
        throw new RuntimeException("Exploto el programa :/");
    }

    public boolean verificarObjetivoCumplido(Socio socio) {
        Objetivo objetivo = socio.getObjetivo();

        if (objetivo instanceof ObjetivoMantenerFigura) {
            boolean rutinaCompletada = rutinaService.verificarCompleto(socio).isCompletada();
            if (socio.getObjetivo().getTipo() == ObjetivoEnum.MANTENER_FIGURA && !rutinaCompletada) {
                return false;
            }
        }

        return objetivo.objetivoCumplido(socio);
    }

    // Método para obtener todos los objetivos
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }
}
