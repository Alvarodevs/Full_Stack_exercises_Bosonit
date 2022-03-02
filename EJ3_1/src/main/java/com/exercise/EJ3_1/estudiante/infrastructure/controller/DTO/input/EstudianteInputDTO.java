package com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor

public class EstudianteInputDTO implements Serializable {

    @NonNull
    private String idPersona;

    @NonNull
    private Integer numHoursWeek;

    private String comments;

    @NonNull
    private String idProfesor;

    @NonNull
    private String branch;

    @NonNull
    List<String> asignaturas;
}
