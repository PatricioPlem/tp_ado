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
        try {
            medida.setSocio(CurrentUserHolder.getCurrentUser());
            Medicion guardadaMedida = medicionService.addMeasurement(medida);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardadaMedida);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/mis-mediciones")
    public ResponseEntity<List<Medicion>> getMeasurements() {
        try{
            List<Medicion> measurements = medicionService.getMeasurements();
            return ResponseEntity.ok(measurements);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }




    }
}
