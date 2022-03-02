package com.exercise.EJ3_1.asignaturas.infrastructure.repository;

import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturasRepo extends JpaRepository<Asignaturas, String> {
}
