package com.Spring_Boot_ex.RS2.objetos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {

    List<Persona> p = new ArrayList<>();

    public int addPersona(int id, String nombre, String poblacion, int edad) {
        p.add(new Persona(id, nombre, poblacion, edad));
        return id;
    }


    public Persona getPersonaById(int id) {
        Optional<Persona> optPers = p.stream()
                                     .filter(p -> p.getId() == id).findFirst();
        return optPers.orElse(null);
    }


    public List<Persona> getPersonaByName(String nombre) {
        return p.stream().filter(p -> p.getNombre()
                                       .equals(nombre)).toList();
    }


    public int setPersona(int id, String newNombre, String newPoblacion, int newEdad) {
        Optional<Persona> optPers = p.stream()
                                     .filter(p -> p.getId() == id).findFirst();
        if (optPers.isPresent()) {
            Persona p = optPers.get();
            p.setNombre(newNombre);
            p.setPoblacion(newPoblacion);
            p.setEdad(newEdad);
            return 1;
        } else return 0;
    }

    public int deletePersona(int id) {
        Optional<Persona> optPers = p.stream()
                .filter(p -> p.getId() == id).findFirst();
        if (optPers.isPresent()) {
          Persona persona = optPers.get();
          p.remove(persona);
          return 1;
        } else return 0;
    }



}
