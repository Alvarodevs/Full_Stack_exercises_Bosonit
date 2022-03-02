package com.exercise.EJ3_1.asignaturas.application;

import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.input.AsignaturasInputDTO;
import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.output.AsignaturasListOutputDTO;
import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.output.AsignaturasOutputDTO;

public interface AsignaturasService {
    public AsignaturasListOutputDTO findAll();
    public AsignaturasOutputDTO filterAsignaturasById(String id);
    public AsignaturasInputDTO addAsignaturas(AsignaturasInputDTO asignaturasInputDTO);
    public AsignaturasOutputDTO setAsignaturas(String id, AsignaturasInputDTO asignaturasInputDTO);
    public void delAsignaturas(String id);
}
