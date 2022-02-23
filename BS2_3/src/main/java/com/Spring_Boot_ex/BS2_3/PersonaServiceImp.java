package com.Spring_Boot_ex.BS2_3;

public class PersonaServiceImp implements PersonaService{

    Persona persona;

    public PersonaServiceImp(String nombre, String poblacion, int edad){
        persona = new Persona(nombre, poblacion, edad);
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }
    public void setPoblacion(String poblacion){
        persona.setPoblacion(poblacion);
    }
    public void setEdad(int edad){
        persona.setEdad(edad);
    }

    public String getNombre(){
        return persona.getNombre();
    }
    public String getPoblacion(){
        return persona.getPoblacion();
    }

    public int getEdad(){
        return persona.getEdad();
    }
}
