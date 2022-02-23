package com.Spring_Boot_ex.RS2.controladores;


import com.Spring_Boot_ex.RS2.objetos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("persona")

public class GetControlador {

    @Autowired
    PersonaService p;

  @Qualifier("personas")
  @GetMapping(value = {"/{id}"})
  public Object getById(@PathVariable int id) {
        Optional<Persona> optPers = Optional.ofNullable(p.getPersonaById(id));
        return optPers.isPresent() ? optPers.get() : "Persona no existe";
    }

    @GetMapping("/nombre/{nombre}")
    public Object getByName(@PathVariable String nombre){
        return p.getPersonaByName(nombre);
    }
}
