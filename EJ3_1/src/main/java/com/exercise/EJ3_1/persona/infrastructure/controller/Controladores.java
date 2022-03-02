package com.exercise.EJ3_1.persona.infrastructure.controller;

import com.exercise.EJ3_1.persona.application.PersonaService;
import com.exercise.EJ3_1.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.exercise.EJ3_1.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controladores {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public List<PersonaOutputDTO> getLista()
    {
        return personaService.getAllPersona();
    }

    @GetMapping("/persona/{id}")
    public PersonaOutputDTO getById(@PathVariable Integer id) throws Exception
    {
        return personaService.getPersonaById(id);
    }

    @GetMapping("/user/{usuario}")
    public List<PersonaOutputDTO> getByNombre(@PathVariable String usuario) throws Exception
    {
        return personaService.getPersonaByUsuario(usuario);
    }

    @PostMapping("/persona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception
    {
        return personaService.addPersona(personaInputDTO);
    }

    @PutMapping("/persona")
    public PersonaOutputDTO setPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception
    {
        return personaService.setPersona(personaInputDTO);
    }

    @DeleteMapping("/persona/{id}")
    public PersonaOutputDTO delById(@PathVariable Integer id) throws Exception
    {
        return personaService.delPersona(id);
    }

}