package com.Spring_Boot_ex.RS1;


import java.util.Optional;

public interface PersonaService {
    Persona getPersona(int id);
    int addPersona(int id, String nombre);
    int setPersona (int id, String newNombre);
}
