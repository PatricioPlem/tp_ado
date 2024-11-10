package com.uade.gympal.Repository;

import com.uade.gympal.Repository.Entity.Ejercicio;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    List<Ejercicio> findEjerciciosByGrupoMuscular(GrupoMuscularEnum grupoMuscular);
}
