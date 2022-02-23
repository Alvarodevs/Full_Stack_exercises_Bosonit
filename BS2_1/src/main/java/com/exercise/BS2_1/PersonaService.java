package com.exercise.BS2_1;

import org.springframework.stereotype.Service;


public interface PersonaService {

    void setNombre(String nombre);
    void setPoblacion(String poblacion);
    void setEdad(int edad);
    String getNombre();
    String getPoblacion();
    int getEdad();
}
