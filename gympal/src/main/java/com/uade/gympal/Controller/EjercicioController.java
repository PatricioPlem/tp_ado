package com.uade.gympal.Controller;

import com.uade.gympal.DTO.EjercicioCompletadoDTO;
import com.uade.gympal.Repository.Entity.EjercicioImplementado;
import com.uade.gympal.Repository.Entity.EjercicioTemplate;
import com.uade.gympal.Service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @PutMapping("")
    public ResponseEntity<EjercicioImplementado> completarEjercicio(@RequestBody EjercicioCompletadoDTO ejercicio) {
        try {
            System.out.println(ejercicio);
            return ResponseEntity.status(HttpStatus.OK).body(ejercicioService.completarEjercicio(ejercicio));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<EjercicioTemplate> crearEjercicioTemplate(@RequestBody EjercicioTemplate ejercicio) {
        try {

            // Guardar el ejercicio utilizando el servicio correspondiente (puede ser un servicio de Ejercicio)
            EjercicioTemplate creado = ejercicioService.crearEjercicio(ejercicio);

            // Retornar la respuesta con el ejercicio creado
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el ejercicio: " + e.getMessage());
        }
    }
}
