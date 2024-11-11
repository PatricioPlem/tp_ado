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
import org.springframework.web.server.ResponseStatusException;


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

    @PutMapping("/cambiar-objetivo")
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
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());

        }
    }

    @PostMapping()
    public ResponseEntity<Socio> createUser(@RequestBody Socio user) {
        try {
            Socio savedUser = socioService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
    @PostMapping("/auth")
    public ResponseEntity<Socio> authenticateUser(@RequestBody Socio user) {
        try {
            return ResponseEntity.ok(socioService.authenticate(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
    @GetMapping(value ="/current", produces = "application/json")
    public ResponseEntity<Socio> getCurrentUser() {
        try {
            Socio currentUser = socioService.getSocio();
            return ResponseEntity.status(HttpStatus.OK).body(currentUser);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No hay un Usuario autenticado"); // Unexpected error
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
