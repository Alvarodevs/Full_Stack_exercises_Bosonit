package com.exercise.EJ3_1.estudiante.infrastructure.repository;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepo extends JpaRepository<Estudiante, String> {
}
