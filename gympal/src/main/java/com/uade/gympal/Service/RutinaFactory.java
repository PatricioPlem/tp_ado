package com.uade.gympal.Service;

import com.uade.gympal.Repository.EjercicioRepository;
import com.uade.gympal.Repository.Entity.*;
import com.uade.gympal.Repository.Enums.ExigenciaMuscularEnum;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RutinaFactory {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public Rutina generarRutina(ObjetivoEnum objetivo) {
        Rutina rutina = new Rutina();
        List<Entrenamiento> entrenamientos = new ArrayList<>();

        // Generar entrenamientos según el objetivo
        switch (objetivo) {
            case BAJAR_PESO:
                entrenamientos = generarEntrenamientosParaBajarPeso();
                break;
            case TONIFICAR:
                entrenamientos = generarEntrenamientosParaTonificar();
                break;
            case MANTENER_FIGURA:
                entrenamientos = generarEntrenamientosParaMantenerFigura();
                break;
            default:
                throw new RuntimeException("Tipo de objetivo no válido");
        }

        rutina.setEntrenamientos(entrenamientos);
        return rutina;
    }

    // Método genérico para generar entrenamientos según el objetivo
    private List<Entrenamiento> generarEntrenamientosPorObjetivo(ObjetivoEnum objetivo, int nivelAerobicoMin, int nivelAerobicoMax, ExigenciaMuscularEnum... exigencias) {
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        int[] dias = {1, 2, 3, 4, 5};
        GrupoMuscularEnum[] gruposMusculares = {
                GrupoMuscularEnum.BRAZO,
                GrupoMuscularEnum.PIERNA,
                GrupoMuscularEnum.ESPALDA,
                GrupoMuscularEnum.PECHO,
                GrupoMuscularEnum.HOMBROS
        };

        for (int dia : dias) {
            GrupoMuscularEnum grupoMuscular = gruposMusculares[dia - 1];

            // Filtrar los ejercicios según el objetivo
            List<EjercicioTemplate> ejerciciosFiltrados = filtrarEjerciciosPorObjetivo(
                    ejercicioRepository.findEjerciciosByGrupoMuscular(grupoMuscular),
                    nivelAerobicoMin,
                    nivelAerobicoMax,
                    exigencias
            );

            Entrenamiento entrenamiento = new Entrenamiento();
            entrenamiento.setDia(dia);
            entrenamiento.setEjercicios(crearEjerciciosImplementados(ejerciciosFiltrados , entrenamiento));
            entrenamientos.add(entrenamiento);
        }

        return entrenamientos;
    }

    // Método para construir la lista de EjercicioImplementado
    private List<EjercicioImplementado> crearEjerciciosImplementados(List<EjercicioTemplate> ejerciciosFiltrados, Entrenamiento entrenamiento) {
        List<EjercicioImplementado> ejerciciosImplementados = new ArrayList<>();
        for (EjercicioTemplate template : ejerciciosFiltrados) {


            ejerciciosImplementados.add(EjercicioImplementado.builder()
                    .entrenamiento(entrenamiento)
                    .ejercicioTemplate(template)
                    .peso(template.getPeso())
                    .series(template.getSeries())
                    .repeticiones(template.getRepeticiones())
                    .completado(false)
                    .build());
        }
        return ejerciciosImplementados;
    }

    // Método para filtrar ejercicios según condiciones de nivel aeróbico y exigencia muscular
    private List<EjercicioTemplate> filtrarEjerciciosPorObjetivo(List<EjercicioTemplate> ejercicios, int nivelAerobicoMin, int nivelAerobicoMax, ExigenciaMuscularEnum... exigencias) {
        Set<EjercicioTemplate> ejerciciosFiltrados = new HashSet<>();
        for (EjercicioTemplate ejercicio : ejercicios) {
            if (ejercicio.getNivelAerobico() >= nivelAerobicoMin &&
                    ejercicio.getNivelAerobico() <= nivelAerobicoMax &&
                    Arrays.asList(exigencias).contains(ejercicio.getExigenciaMuscular())) {
                ejerciciosFiltrados.add(ejercicio);
            }
        }
        return new ArrayList<>(ejerciciosFiltrados);
    }

    // Generación de entrenamientos para bajar peso
    private List<Entrenamiento> generarEntrenamientosParaBajarPeso() {
        return generarEntrenamientosPorObjetivo(
                ObjetivoEnum.BAJAR_PESO,
                3,    // Mínimo nivel aeróbico
                Integer.MAX_VALUE,    // Sin límite superior
                ExigenciaMuscularEnum.ALTA,
                ExigenciaMuscularEnum.MEDIA,
                ExigenciaMuscularEnum.BAJA
        );
    }

    // Generación de entrenamientos para tonificar
    private List<Entrenamiento> generarEntrenamientosParaTonificar() {
        return generarEntrenamientosPorObjetivo(
                ObjetivoEnum.TONIFICAR,
                1,    // Mínimo nivel aeróbico
                4,    // Máximo nivel aeróbico
                ExigenciaMuscularEnum.ALTA
        );
    }

    // Generación de entrenamientos para mantener figura
    private List<Entrenamiento> generarEntrenamientosParaMantenerFigura() {
        return generarEntrenamientosPorObjetivo(
                ObjetivoEnum.MANTENER_FIGURA,
                2,    // Mínimo nivel aeróbico
                4,    // Máximo nivel aeróbico
                ExigenciaMuscularEnum.MEDIA,
                ExigenciaMuscularEnum.BAJA
        );
    }
}
