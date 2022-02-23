package com.Spring_Boot_ex.RS1;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador {

    @Autowired PersonaService ps;
    //private final AtomicInteger id = new AtomicInteger();

    @PostMapping("/addPersona")
    public Object addPersona(@RequestBody Map<String,Object> body){
        String error = "Wrong or missing data";

        if (body == null){
            return error;
        }
        if (body.get("nombre") == "" || body.get("nombre") == null) {
            return error;
        }
        if (body.get("id") == "" || body.get("id") == null){
            return error;
        }
        String nombre = body.get("nombre").toString(); //convertir a string, recibido objeto
        int id = Integer.parseInt(body.get("id").toString());
        ps.addPersona(id, nombre);

        return new Persona(id, nombre);
    }


    @GetMapping("/getPersona/{id}")
    public Object getPersona(@PathVariable int id){
        Optional<Persona> persona = Optional.ofNullable(ps.getPersona(id));
        String error = "Persona no existe";

        return persona.isPresent() ? persona.get(): error;
    }

    @PutMapping("/post")
    public Object setPersona(@RequestParam(value = "id") int id, @RequestParam(value="nombre") String nombre){
        int isUpdated = ps.setPersona(id, nombre);
        return isUpdated == 1 ? "Updated persona" : "Error";
    }
}