package com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class EstudianteOutputDTO implements Serializable {
    private String idEstudiante;
    private String idPersona;
    private Integer numHoursWeek;
    private String comments;
    private String idProfesor;
    private String branch;
    List<String> asignaturas;

    public EstudianteOutputDTO(Estudiante estudiante){
        if(estudiante==null)
            return;
        setIdEstudiante(estudiante.getIdEstudiante());
        setIdPersona(String.valueOf(estudiante.getIdPersona().getId()));
        setNumHoursWeek(estudiante.getNumHoursWeek());
        setComments(estudiante.getComments());
        setIdProfesor(estudiante.getIdProfesor().getIdProfesor());
        setBranch(estudiante.getBranch());

        List<String> asignaturas = new ArrayList<>();
        if(estudiante.getAsignaturas().size()!=0){
            for(int i = 0; i < estudiante.getAsignaturas().size(); i++){
                asignaturas.add(estudiante.getAsignaturas().get(i).getAsignatura());
            }
        }
        setAsignaturas(asignaturas);
    }
}