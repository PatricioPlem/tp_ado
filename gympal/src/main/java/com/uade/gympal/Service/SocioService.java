package com.uade.gympal.Service;


import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.SocioRepository;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SocioService {

    @Autowired
    private SocioRepository userRepository;


    public List<Socio> findAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public Socio authenticate(String username, String password) {
        Socio socio = userRepository.findByUsername(username);
        if (socio.getPassword().equals(password)) {
            CurrentUserHolder.setCurrentUser(socio);
            return socio;
        }
        throw new RuntimeException("Invalid username or password");
    }

    public Socio saveUser(Socio user) {

        // Check if a user with the same username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    }

