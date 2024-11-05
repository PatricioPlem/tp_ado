package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    Socio findByUsername(String username);
}
