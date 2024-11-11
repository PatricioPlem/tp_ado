package com.uade.gympal.Controller;



import com.uade.gympal.Repository.Entity.Entrenamiento;
import com.uade.gympal.Repository.Entity.Rutina;

import com.uade.gympal.Service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rutina")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping
    public ResponseEntity<List<Rutina>> getAllRutina() {
        return ResponseEntity.ok(rutinaService.getAll());
    }

    @PostMapping
    public ResponseEntity<Rutina> crearRutina(@RequestBody List<Entrenamiento> entrenamientos) {
        Rutina rutinaCreada = rutinaService.crearRutina(entrenamientos);
        return ResponseEntity.ok(rutinaCreada);
    }
    @PutMapping("/reforzar")
    public ResponseEntity<Rutina> reforzarRutina() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rutinaService.reforzarRutina());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/{id}/completar")
    public ResponseEntity<String> completarRutina(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rutinaService.completarRutina(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }



}
