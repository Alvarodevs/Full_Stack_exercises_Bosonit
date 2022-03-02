package com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.output;

import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AsignaturasOutputDTO implements Serializable {
    private String idEstudio;
    private List<String> estudiantes;
    private String asignaturas;
    private String comments;
    private Date initialDate;
    private Date finishDate;

    public AsignaturasOutputDTO(Asignaturas asignaturas){
        if(asignaturas==null)
            return;
        setIdEstudio(asignaturas.getIdAsignatura());

        List<String> estudiantes = new ArrayList<>();
        if(asignaturas.getEstudiantes().size()!=0){
            for(int i = 0; i < asignaturas.getEstudiantes().size(); i++){
                estudiantes.add(asignaturas.getEstudiantes().get(i).getIdEstudiante());
            }
        }
        setEstudiantes(estudiantes);

        setAsignaturas(asignaturas.getAsignatura());
        setComments(asignaturas.getComments());
        setInitialDate(asignaturas.getInitialDate());
        setFinishDate(asignaturas.getFinishDate());
    }
}
