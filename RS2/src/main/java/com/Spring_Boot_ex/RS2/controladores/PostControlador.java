package com.Spring_Boot_ex.RS2.controladores;

import com.Spring_Boot_ex.RS2.objetos.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("persona")

public class PostControlador {

    @Autowired
    PersonaService p;
    @Qualifier("personas")

    @PostMapping()
    public String addPersona(@RequestBody Map<String, Object> body) {
        String error = "Wrong or missing data";

        if (body == null){
            return error;
        }
        if (body.get("id") == "" || body.get("id") == null){
            return error;
        }
        if (body.get("nombre") == "" || body.get("nombre") == null) {
            return error;
        }
        if (body.get("poblacion") == "" || body.get("poblacion") == null){
            return error;
        }
        if (body.get("edad") == "" || body.get("edad") == null){
            return error;
    } else {
          int id = Integer.parseInt(body.get("id").toString());
          String nombre = body.get("nombre").toString(); // convertir a string, recibido objeto
          String poblacion = body.get("poblacion").toString();
          int edad = Integer.parseInt(body.get("edad").toString());

          p.addPersona(id, nombre, poblacion, edad);

          return "Persona " + nombre + " con id: " + id + " añadida.";
        }
    }
}