package com.exercise.BS2_1;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService{
    Persona p = new Persona();

    public void setNombre(String nombre) { p.setNombre(nombre); }
    public void setPoblacion(String poblacion) { p.setPoblacion(poblacion); }
    public void setEdad(int edad) { p.setEdad(edad); }

    public String getNombre() { return p.getNombre(); }
    public String getPoblacion() { return p.getPoblacion(); }
    public int getEdad() { return p.getEdad(); }
}
