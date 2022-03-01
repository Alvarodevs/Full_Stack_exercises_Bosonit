package com.exercise.BS8.persona.infrastructure.controller.dto;

import com.exercise.BS8.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDTO {
    private Integer id;
    String usuario;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;

    public PersonaOutputDTO(Persona persona){
        this.id = persona.getId();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.isActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
    }
}
