package com.Spring_Boot_ex.RS2.objetos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private int id;
    private String nombre, poblacion;
    private int edad;
}
