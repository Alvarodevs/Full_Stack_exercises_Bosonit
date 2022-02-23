package com.exercise.BS2_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired PersonaService ps;
    @GetMapping("/controlador2/persona_double_age")
    Persona getPersona(){
        return new Persona(ps.getNombre(), ps.getPoblacion(),ps.getEdad()*2);
    }
}
