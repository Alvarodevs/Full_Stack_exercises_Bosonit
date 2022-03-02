package com.exercise.EJ3_1.profesor.infrasctructure.repository;

import com.exercise.EJ3_1.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor, String> {
}
