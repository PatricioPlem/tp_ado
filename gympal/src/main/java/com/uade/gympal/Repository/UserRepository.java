package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos de consulta personalizados si se necesitan
}
