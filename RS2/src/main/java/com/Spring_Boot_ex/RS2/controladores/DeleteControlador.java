package com.Spring_Boot_ex.RS2.controladores;

import com.Spring_Boot_ex.RS2.objetos.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class DeleteControlador {

    @Autowired
    PersonaService p;

    @DeleteMapping("/{id}")
        public String deletePersona(@PathVariable int id){
        int personaToDelete = p.deletePersona(id);
        return (personaToDelete == 1) ? "Persona eliminada" : null;
    }
}
