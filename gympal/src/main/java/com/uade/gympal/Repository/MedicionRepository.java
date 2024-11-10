package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    List<Medicion> findBySocioId(Long socioId); // To get measurements for a specific user
}
