package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetivo")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    // Endpoint para obtener todos los objetivos
    @GetMapping
    public ResponseEntity<List<Objetivo>> getAllObjetivos() {
        List<Objetivo> objetivos = objetivoService.getAllObjetivos();
        return ResponseEntity.ok(objetivos);
    }

    // Endpoint para crear un nuevo objetivo
    @PostMapping
    public ResponseEntity<Objetivo> createObjetivo(@RequestBody Objetivo objetivo) {
        Objetivo nuevoObjetivo = objetivoService.createObjetivo(objetivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoObjetivo);
    }
}
