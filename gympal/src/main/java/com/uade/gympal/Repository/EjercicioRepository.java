package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.EjercicioTemplate;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioTemplate, Long> {
    List<EjercicioTemplate> findEjerciciosByGrupoMuscular(GrupoMuscularEnum grupoMuscular);
}
