package com.Spring_Boot_ex.RS2.objetos;


import java.util.List;

public interface PersonaService {
    int addPersona(int id, String newNombre, String newPoblacion, int newEdad);

    //getters
    Persona getPersonaById(int id);
    List<Persona> getPersonaByName(String nombre);

    //setters
    int setPersona (int id, String newNombre, String newPoblacion, int newEdad);
    int deletePersona (int id);
}
