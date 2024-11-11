package com.uade.gympal.Service;


import com.uade.gympal.Auth.AuthAdapter;
import com.uade.gympal.Auth.AuthConcreta;
import com.uade.gympal.Repository.Entity.Objetivo;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.Enums.ObjetivoEnum;
import com.uade.gympal.Repository.ObjetivoRepository;
import com.uade.gympal.Repository.SocioRepository;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private ObjetivoService objetivoService;
    @Autowired
    private AuthAdapter authAdapter;



    public List<Socio> findAllUsers() {
        return socioRepository.findAll();
    }
    @Transactional
    public Socio authenticate(String username, String password) {
        CurrentUserHolder.setCurrentUser(authAdapter.autenticar(username, password));
        return CurrentUserHolder.getCurrentUser();
    }

    public Socio saveUser(Socio user) {

        // Check if a user with the same username already exists
        if (socioRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        return socioRepository.save(user);

    }

    public void deleteUser(Long id) {
        socioRepository.deleteById(id);
    }

    public Socio cambiarObjetivo(ObjetivoEnum objetivo) {
        // Obtener el socio por su ID
        Socio socio = CurrentUserHolder.getCurrentUser();
        //borrar antiguo objetivo para limpiar DB
        socio.setObjetivo(null);
        socioRepository.save(socio);

        // Crear el nuevo objetivo con la rutina correspondiente
        Objetivo objetivoNuevo = objetivoService.createObjetivo(objetivo);

        // Asignar el nuevo objetivo al socio
        socio.setObjetivo(objetivoNuevo);

        // Guardar el socio actualizado
        return socioRepository.save(socio);
    }

    public Socio getSocio() {
        return socioRepository.findById(CurrentUserHolder.getCurrentUser().getId()).orElseThrow();
    }

    }

