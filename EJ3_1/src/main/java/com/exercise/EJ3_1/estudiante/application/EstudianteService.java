package com.exercise.EJ3_1.estudiante.application;

import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.input.EstudianteInputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudianteOutputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudiantesListOutputDTO;

import java.util.List;

public interface EstudianteService {
    public EstudiantesListOutputDTO findAll();
    public EstudianteOutputDTO getStudentById(String id, String outputType);
    public EstudianteInputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO);
    public EstudianteOutputDTO setEstudiante(String id, EstudianteInputDTO estudianteInputDTO);
    public void delEstudiante(String id);
    public List<String> addAsignaturas(String id, List<String> asignaturas);
    public List<String> delAsignaturas(String id, List<String> asignaturas);
}
