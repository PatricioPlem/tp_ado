package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/objetivo",produces = "application/json")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    // Endpoint para obtener todos los objetivos
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Objetivo>> getAllObjetivos() {
        List<Objetivo> objetivos = objetivoService.getAllObjetivos();
        return ResponseEntity.ok(objetivos);
    }

}
