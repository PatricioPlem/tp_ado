package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.*;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoConstancia;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoDedicacion;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Objetivo createObjetivo(ObjetivoEnum objetivoEnum) {
        Rutina rutina = rutinaFactory.generarRutina(objetivoEnum);
        Objetivo objetivo;

        switch (objetivoEnum) {
            case BAJAR_PESO:
                objetivo = ObjetivoBajarPeso.builder()
                        .pesoIdeal(60)
                        .tipo(objetivoEnum)
                        .rutina(rutina)
                        .build();
                break;

            case TONIFICAR:
                objetivo = ObjetivoTonificar.builder()
                        .IMC(20)
                        .porcentajeGrasa(12)
                        .tipo(objetivoEnum)
                        .rutina(rutina)
                        .build();
                break;

            case MANTENER_FIGURA:
                objetivo = ObjetivoMantenerFigura.builder()
                        .tipo(objetivoEnum)
                        .rutina(rutina)
                        .pesoInicial(70)
                        .variacionPeso(2.5F)
                        .build();
                break;

            default:
                throw new RuntimeException("Objetivo desconocido");
        }

        // Agregar ambos observadores a todos los objetivos
        agregarObservers(objetivo);

        return objetivo;
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

    private void agregarObservers(Objetivo objetivo) {
        objetivo.setObservers(new ArrayList<>(List.of(new TrofeoDedicacion(), new TrofeoConstancia())));
    }
}
