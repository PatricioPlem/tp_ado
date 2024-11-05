package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> { }
