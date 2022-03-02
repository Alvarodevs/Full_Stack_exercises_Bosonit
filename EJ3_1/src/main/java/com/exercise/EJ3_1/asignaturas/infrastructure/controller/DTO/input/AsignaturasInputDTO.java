package com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AsignaturasInputDTO implements Serializable {

    @NonNull
    private List<String> estudiantes;

    @NonNull
    private String asignaturas;

    private String comments;

    @NonNull
    private Date initialDate;

    private Date finishDate;
}
