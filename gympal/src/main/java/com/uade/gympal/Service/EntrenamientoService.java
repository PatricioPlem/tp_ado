package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.EjercicioImplementado;
import com.uade.gympal.Repository.Entity.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntrenamientoService {


    @Autowired
    private EjercicioService ejercicioService;


    // Método que recorre los ejercicios implementados y les solicita "reforzar"
    public void reforzarEntrenamiento(Entrenamiento entrenamiento) {
        // Obtener los ejercicios implementados de un entrenamiento
        List<EjercicioImplementado> ejercicios = entrenamiento.getEjercicios();

        // Iterar sobre los ejercicios y aplicar el método de reforzar
        for (EjercicioImplementado ejercicio : ejercicios) {
            // Llamar al método reforzar del ejercicio
            ejercicioService.reforzarEjercicio(ejercicio);
        }

    }
    public boolean verificarCompletado(Entrenamiento entrenamiento) {
        List<EjercicioImplementado> ejercicios = entrenamiento.getEjercicios();

        for (EjercicioImplementado ejercicio : ejercicios) {
            if (!ejercicioService.verificarCompletado(ejercicio)){
                return false;
            }
        }
        return true;
    }
}
