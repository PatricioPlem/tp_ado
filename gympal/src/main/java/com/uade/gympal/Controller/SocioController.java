package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Service.ObjetivoService;
import com.uade.gympal.Service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @Autowired
    private ObjetivoService objetivoService;


    @GetMapping
    public ResponseEntity<List<Socio>> getAllUsers() {
        return ResponseEntity.ok(socioService.findAllUsers());
    }

    @PostMapping("/cambiar-objetivo")
    public ResponseEntity<Socio> cambiarObjetivo(@RequestBody ObjetivoEnum objetivo) {
        // Llamar al servicio para cambiar el objetivo
        System.out.println(objetivo);
        Socio socioActualizado = socioService.cambiarObjetivo(objetivo);

        // Retornar el socio actualizado
        return ResponseEntity.ok(socioActualizado);
    }




    @PostMapping
    public ResponseEntity<Socio> createUser(@RequestBody Socio user) {
        try {
            return ResponseEntity.ok(socioService.saveUser(user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/auth")
    public ResponseEntity<Socio> authenticateUser(@RequestBody Socio user) {
        try {
            return ResponseEntity.ok(socioService.authenticate(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/current")
    public ResponseEntity<Socio> getCurrentUser() {
        Socio currentUser = CurrentUserHolder.getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser);
        }

        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/logoff")
    public ResponseEntity<Void> clearCurrentUser () {
       CurrentUserHolder.clear();
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        socioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
