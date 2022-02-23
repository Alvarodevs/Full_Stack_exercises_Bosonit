package com.exercise.BS2_1;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class Persona {

    private String nombre, poblacion;
    private int edad;
}
