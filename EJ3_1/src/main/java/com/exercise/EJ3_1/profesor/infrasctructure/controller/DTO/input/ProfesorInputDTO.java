package com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfesorInputDTO {

    @NonNull
    private String idPersona;

    private String comments;

    @NonNull
    private String branch;

    private List<String> students;
}
