package com.exercise.EJ2.persona.infrastructure.controller.dto;

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
}
