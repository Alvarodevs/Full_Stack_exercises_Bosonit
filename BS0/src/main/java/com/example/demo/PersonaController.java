package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @GetMapping("/user/{name}")
    public String saludo(@PathVariable String name){
        return "Hola " + name;
    }

    @PostMapping("/useradd")
    public Persona addPersona(@RequestBody Persona newPersona){
        return new Persona(newPersona.getNombre(), newPersona.getPoblacion(), newPersona.getEdad()+1);
    }
}
