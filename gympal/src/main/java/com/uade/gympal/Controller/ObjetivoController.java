package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Service.ObjetivoService;
import com.uade.gympal.Service.SocioService;
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
    @Autowired
    private SocioService socioService;

    // Endpoint para obtener todos los objetivos
    @GetMapping()
    public ResponseEntity<Objetivo> getUserObjetivo() {
        Objetivo objetivo = objetivoService.getUserObjetivo(socioService.getSocio());
        return ResponseEntity.ok(objetivo);
    }

}
