package com.uade.gympal.Service;

import com.uade.gympal.DTO.EjercicioCompletadoDTO;
import com.uade.gympal.Repository.EjercicioImplementadoRepository;

import com.uade.gympal.Repository.EjercicioRepository;
import com.uade.gympal.Repository.Entity.EjercicioImplementado;

import com.uade.gympal.Repository.Entity.EjercicioTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EjercicioService {

    @Autowired
    private EjercicioImplementadoRepository ejercicioImplementadoRepository;
    @Autowired
    private EjercicioRepository ejercicioRepository;

    public EjercicioImplementado completarEjercicio(EjercicioCompletadoDTO ejercicio) {
        EjercicioImplementado ejercicioImplementado = ejercicioImplementadoRepository.findById(ejercicio.getId()).orElseThrow();
        System.out.println(ejercicioImplementado.getNombre());
        ejercicioImplementado.setCompletado(true);
        ejercicioImplementado.setPesoUsado(ejercicio.getPeso());
        ejercicioImplementado.setRepeticionesRealizadas(ejercicio.getRepeticiones());
        ejercicioImplementado.setSeriesRealizadas(ejercicio.getSeries());

        return ejercicioImplementadoRepository.save(ejercicioImplementado);
    }

    public EjercicioTemplate crearEjercicio(EjercicioTemplate ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

}
