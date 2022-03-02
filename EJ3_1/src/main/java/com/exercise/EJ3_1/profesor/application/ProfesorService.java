package com.exercise.EJ3_1.profesor.application;

import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.input.ProfesorInputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorListOutputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorOutputDTO;

public interface ProfesorService {
    public ProfesorListOutputDTO findAll();
    public ProfesorOutputDTO filterProfesorById(String id);
    public ProfesorInputDTO addProfesor(ProfesorInputDTO profesorInputDTO);
    public ProfesorOutputDTO setProfesor(String id, ProfesorInputDTO profesorInputDTO);
    public void delProfesor(String id);
}
