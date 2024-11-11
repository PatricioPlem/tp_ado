package com.uade.gympal.Auth;

import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthConcreta implements AuthAdapter {

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public Socio autenticar(String username, String password) {
        Socio socio = socioRepository.findByUsername(username);
        if (socio != null && socio.getPassword().equals(password)) {
            return socio;
        }
        return null;
    }
}
