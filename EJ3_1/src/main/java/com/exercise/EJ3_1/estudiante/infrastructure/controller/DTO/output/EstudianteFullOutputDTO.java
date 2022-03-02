package com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteFullOutputDTO extends EstudianteOutputDTO {

    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;

    public EstudianteFullOutputDTO(Estudiante estudiante){
        super(estudiante);
        setUsuario(estudiante.getIdPersona().getUsuario());
        setPassword(estudiante.getIdPersona().getPassword());
        setName(estudiante.getIdPersona().getName());
        setSurname(estudiante.getIdPersona().getSurname());
        setCompany_email(estudiante.getIdPersona().getCompany_email());
        setPersonal_email(estudiante.getIdPersona().getPersonal_email());
        setCity(estudiante.getIdPersona().getCity());
        setActive(estudiante.getIdPersona().isActive());
        setCreated_date(estudiante.getIdPersona().getCreated_date());
        setImagen_url(estudiante.getIdPersona().getImagen_url());
        setTermination_date(estudiante.getIdPersona().getTermination_date());

    }
}