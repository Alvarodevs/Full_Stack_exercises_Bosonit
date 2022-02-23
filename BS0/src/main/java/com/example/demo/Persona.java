package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Persona {

    private String nombre;
    private String poblacion;
    private int edad;

}
