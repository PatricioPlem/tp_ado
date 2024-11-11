package com.uade.gympal.Auth;

import com.uade.gympal.Repository.Entity.Socio;

public interface AuthAdapter {
    Socio autenticar(String username, String password);
}
