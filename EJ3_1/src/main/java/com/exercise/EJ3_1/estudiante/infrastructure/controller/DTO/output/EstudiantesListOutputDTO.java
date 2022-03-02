package com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class EstudiantesListOutputDTO {
    private List<EstudianteOutputDTO> estudianteListOutputDTO;
}
