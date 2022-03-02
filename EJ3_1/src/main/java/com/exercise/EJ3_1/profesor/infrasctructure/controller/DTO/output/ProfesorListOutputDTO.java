package com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfesorListOutputDTO {
    private List<ProfesorOutputDTO> profesorListOutputDTO;
}
