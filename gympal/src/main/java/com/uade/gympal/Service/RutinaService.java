package com.uade.gympal.Service;

import com.uade.gympal.DTO.RutinaCompletadaDTO;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Entrenamiento;
import com.uade.gympal.Repository.Entity.Rutina;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.RutinaRepository;
import com.uade.gympal.Repository.SocioRepository;
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
    @Autowired
    private SocioRepository socioRepository;

    public List<Rutina> getAll() {
        return rutinaRepository.findAll();
    }

    public Rutina crearRutina(List<Entrenamiento> entrenamientos) {
        Rutina nuevaRutina = Rutina.builder()
                .entrenamientos(entrenamientos)
                .build();

        return rutinaRepository.save(nuevaRutina);
    }
    public Rutina reforzarRutina(Socio socio) {
        Rutina rutina = socio.getObjetivo().getRutina();
        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            entrenamientoService.reforzarEntrenamiento(entrenamiento);
        }
        return CurrentUserHolder.getCurrentUser().getObjetivo().getRutina();
    }

    public RutinaCompletadaDTO verificarCompleto(Socio socio) {
        Rutina rutina = socio.getObjetivo().getRutina();
        RutinaCompletadaDTO response = RutinaCompletadaDTO.builder().rutinaId(rutina.getId()).completada(false).socioName(socio.getUsername()).build();
        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            if (!entrenamientoService.verificarCompletado(entrenamiento)) {
                return response;
            }

        }
        response.setCompletada(true);
        return response;

    }
}
