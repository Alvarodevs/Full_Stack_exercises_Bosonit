package com.Spring_Boot_ex.RS1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService{

    ArrayList<Persona> personas = new ArrayList<>();

    public int addPersona(int id, String nombre) {
        personas.add(new Persona(id, nombre) {
        });
        return 1;
    }

    public Persona getPersona(int id) {
        Optional<Persona> persOpc = personas.stream()
                                            .filter(p -> p.getId() == id).findAny();
        return persOpc.orElse(null);
    }

    @Override
    public int setPersona(int id, String newNombre) {
        Optional<Persona> persOpc = personas.stream()
                                            .filter(p -> p.getId() == id).findAny();
        Persona p = persOpc.get();
        p.setNombre(newNombre);
        return 1;
    }

}
