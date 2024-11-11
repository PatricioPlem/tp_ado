package com.uade.gympal.Controller;



import com.uade.gympal.DTO.RutinaCompletadaDTO;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Entrenamiento;
import com.uade.gympal.Repository.Entity.Rutina;

import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Service.RutinaService;
import com.uade.gympal.Service.SocioService;
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
    @Autowired
    private SocioService socioService;

    @GetMapping
    public ResponseEntity<List<Rutina>> getAllRutina() {
        return ResponseEntity.ok(rutinaService.getAll());
    }

    @PostMapping
    public ResponseEntity<Rutina> crearRutina(@RequestBody List<Entrenamiento> entrenamientos) {
        Rutina rutinaCreada = rutinaService.crearRutina(entrenamientos);
        return ResponseEntity.ok(rutinaCreada);
    }
    @GetMapping("/verificar")
    public ResponseEntity<RutinaCompletadaDTO> verificar() {
        try {
            Socio socioAutenticado = socioService.getSocio();
            return ResponseEntity.status(HttpStatus.OK).body(rutinaService.verificarCompleto(socioAutenticado));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/reforzar")
    public ResponseEntity<Rutina> reforzarRutina() {
        try {
            Socio socioAutenticado = socioService.getSocio();
            return ResponseEntity.status(HttpStatus.OK).body(rutinaService.reforzarRutina(socioAutenticado));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }



}
