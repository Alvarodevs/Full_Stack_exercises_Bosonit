package com.Spring_Boot_ex.RS2.controladores;

import com.Spring_Boot_ex.RS2.objetos.Persona;
import com.Spring_Boot_ex.RS2.objetos.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("persona")

public class PutControlador {

    @Autowired
    PersonaService p;

  @PutMapping("/{id}")
  public String setPersona(@PathVariable int id, @RequestBody Map<String, Object> body) {
    String error = "Wrong or missing data";

    if (body == null) {
      return error;
    }
    if (body.get("nombre") == "" || body.get("nombre") == null) {
      return error;
    }
    if (body.get("poblacion") == "" || body.get("poblacion") == null) {
      return error;
    }
    if (body.get("edad") == "" || body.get("edad") == null) {
      return error;
    } else {
      String nombre = body.get("nombre").toString(); // convertir a string, recibido objeto
      String poblacion = body.get("poblacion").toString();
      int edad = Integer.parseInt(body.get("edad").toString());

      int updatedPersona = p.setPersona(id, nombre, poblacion, edad);
      return (updatedPersona == 1) ? "Persona actualizada" : error;
    }
  }
}
