package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.CurrentUserHolder;

import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoDedicacion;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Service.ObjetivoService;
import com.uade.gympal.Service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @Autowired
    private ObjetivoService objetivoService;


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Socio>> getAllUsers() {
        return ResponseEntity.ok(socioService.findAllUsers());
    }

    @PostMapping("/cambiar-objetivo")
    public ResponseEntity<Socio> cambiarObjetivo(@RequestBody ObjetivoEnum objetivo) {
        try {
            // Llamar al servicio para cambiar el objetivo
            System.out.println(objetivo);
            Socio socioActualizado = socioService.cambiarObjetivo(objetivo);

            // Agregar observer para trofeo
            if (socioActualizado.getObservers().isEmpty()) { socioActualizado.agregar(new TrofeoDedicacion()); }

            // Retornar el socio actualizado
            return ResponseEntity.ok(socioActualizado);
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }
    }

    @PostMapping()
    public ResponseEntity<Socio> createUser(@RequestBody Socio user) {
        try {
            Socio savedUser = socioService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PostMapping("/auth")
    public ResponseEntity<Socio> authenticateUser(@RequestBody Socio user) {
        try {
            return ResponseEntity.ok(socioService.authenticate(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping(value ="/current", produces = "application/json")
    public ResponseEntity<Socio> getCurrentUser() {
        try {
            Socio currentUser = CurrentUserHolder.getCurrentUser();
            if (currentUser != null) {
                return ResponseEntity.ok(currentUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Unexpected error
        }
    }


    @PostMapping(value="/logoff", produces = "application/json")
    public ResponseEntity<Void> clearCurrentUser () {
        Socio currentUser = CurrentUserHolder.getCurrentUser();
        currentUser.clearObservers();

        CurrentUserHolder.clear();
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try{
        socioService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
