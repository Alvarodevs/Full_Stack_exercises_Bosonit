package com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output;

import com.exercise.EJ3_1.profesor.domain.Profesor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorOutputDTO implements Serializable {
    private String idProfesor;
    private String idPersona;
    private String comments;
    private String branch;
    private List<String> students = new ArrayList();

    public ProfesorOutputDTO(Profesor profesor){
        if(profesor==null)
            return;
        setIdProfesor(profesor.getIdProfesor());
        setIdPersona(String.valueOf(profesor.getIdPersona().getId()));
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
        if(profesor.getEstudiantes().size()!=0){
            for(int i = 0; i < profesor.getEstudiantes().size(); i++){
                students.add(profesor.getEstudiantes().get(i).getIdEstudiante());
            }
        }
    }
}
