package com.exercise.BS2_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired PersonaService ps;
    @GetMapping("/controlador1/addPersona")
       public Object addPersona(@RequestHeader String nombre, @RequestHeader String poblacion, @RequestHeader int edad) {
            ps.setNombre(nombre);
            ps.setPoblacion(poblacion);
            ps.setEdad(edad);

            return new Persona(nombre, poblacion, edad);
        }
}
