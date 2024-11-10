package com.uade.gympal.Controller;


import com.uade.gympal.Repository.Entity.Entrenamiento;
import com.uade.gympal.Repository.Entity.Rutina;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}/completar")
    public ResponseEntity<String> completarRutina(@PathVariable Long id) {

        return ResponseEntity.ok(rutinaService.completarRutina(id));
    }


}
