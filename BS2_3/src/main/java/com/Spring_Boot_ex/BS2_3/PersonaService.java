package com.Spring_Boot_ex.BS2_3;

import java.util.ArrayList;

public interface PersonaService {
    void setNombre(String nombre);
    void setPoblacion(String poblacion);
    void setEdad (int edad);

    String getNombre();
    String getPoblacion();
    int getEdad();
}
