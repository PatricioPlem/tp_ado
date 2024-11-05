package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoService {

    private final ObjetivoRepository objetivoRepository;

    @Autowired
    public ObjetivoService(ObjetivoRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }

    // Método para obtener todos los objetivos
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }

    // Método para crear un nuevo objetivo
    public Objetivo createObjetivo(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }
}
