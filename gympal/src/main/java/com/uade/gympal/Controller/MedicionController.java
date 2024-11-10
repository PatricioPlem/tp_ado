package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.CurrentUserHolder;

import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.Entity.Medicion;

import com.uade.gympal.Service.MedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/medidas")
public class MedicionController {

    @Autowired
    private MedicionService medicionService;

    @PostMapping("/agregar")
    public ResponseEntity<Medicion> addMeasurement(@RequestBody Medicion medida) {
        Socio socio = CurrentUserHolder.getCurrentUser();
        if (socio == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        else {
            medida.setSocio(socio);
            Medicion guardadaMedida = medicionService.addMeasurement(medida);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardadaMedida);
        }
    }

    @GetMapping("/mis-mediciones")
    public ResponseEntity<List<Medicion>> getMeasurements() {
        Socio miSocio = CurrentUserHolder.getCurrentUser();
        if (miSocio == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        else{
            List<Medicion> measurements = medicionService.getMeasurements();
            return ResponseEntity.ok(measurements);
        }

    }
}
