package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.EjercicioTemplate;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjercicioRepository extends JpaRepository<EjercicioTemplate, Long> {
    List<EjercicioTemplate> findEjerciciosByGrupoMuscular(GrupoMuscularEnum grupoMuscular);
}
