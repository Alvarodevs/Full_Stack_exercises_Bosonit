package com.Spring_Boot_ex.BS2_2;

import java.util.ArrayList;

public class ListaDeCiudadesServiceImp implements ListaDeCiudadesService {

    ArrayList<Ciudad> ciudades= new ArrayList<>();

    public ArrayList<Ciudad> getCiudades(){
        return ciudades;
    }

    public void addCiudad(Ciudad ciudad){
        ciudades.add(ciudad);
    }
}
