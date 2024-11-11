package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Entrenamiento;
import com.uade.gympal.Repository.Entity.Rutina;
import com.uade.gympal.Repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private EntrenamientoService entrenamientoService;

    public List<Rutina> getAll() {
        return rutinaRepository.findAll();
    }

    public Rutina crearRutina(List<Entrenamiento> entrenamientos) {
        Rutina nuevaRutina = Rutina.builder()
                .entrenamientos(entrenamientos)
                .completada(false) // Nueva rutina creada como no completada
                .build();

        return rutinaRepository.save(nuevaRutina);
    }
    public Rutina reforzarRutina() {
        Rutina rutina = CurrentUserHolder.getCurrentUser().getObjetivo().getRutina();
        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            entrenamientoService.reforzarEntrenamiento(entrenamiento);
        }
        return CurrentUserHolder.getCurrentUser().getObjetivo().getRutina();
    }

    public String completarRutina(Long id) {
        Optional<Rutina> rutina = rutinaRepository.findById(id);
        if (rutina.isPresent()) {
            Rutina rutinaExistente = rutina.get(); // Obtener el objeto Rutina
            rutinaExistente.setCompletada(true);
            rutinaRepository.save(rutinaExistente); // Guardar el objeto Rutina
            return "Rutina completada!";
        }
        return "salio todo mal";

    }
}
