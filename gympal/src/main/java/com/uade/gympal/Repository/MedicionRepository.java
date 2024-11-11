package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    List<Medicion> findBySocioId(Long socioId); // por ID
    List<Medicion> findBySocioIdAndDateTimeAfter(Long socioId, LocalDateTime dateTime); // por ID e intervalo de tiempo
}
