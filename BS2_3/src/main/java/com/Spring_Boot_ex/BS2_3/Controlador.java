package com.Spring_Boot_ex.BS2_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired @Qualifier("b1") PersonaService p1;
    @Autowired @Qualifier("b2") PersonaService p2;
    @Autowired @Qualifier("b3") PersonaService p3;

    @GetMapping("/controlador/bean/{bean}")
    public Object getPersona(@PathVariable String bean) {

        switch (bean){
            case "b1": return new Persona(p1.getNombre(), p1.getPoblacion(), p1.getEdad());
            case "b2": return new Persona(p2.getNombre(), p2.getPoblacion(), p2.getEdad());
            case "b3": return new Persona(p3.getNombre(), p3.getPoblacion(), p3.getEdad());
            default: return "Data error";
        }
    }
}
