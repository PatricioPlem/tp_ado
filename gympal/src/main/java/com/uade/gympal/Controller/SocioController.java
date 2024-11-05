package com.uade.gympal.Controller;

import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SocioController {

    private final SocioService userService;

    @Autowired
    public SocioController(SocioService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Socio>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/auth")
    public ResponseEntity<Socio> authenticateUser(@RequestBody Socio user) {
        try {
            return ResponseEntity.ok(userService.authenticate(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Socio> createUser(@RequestBody Socio user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
