package com.Spring_Boot_ex.BS2_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired ListaDeCiudadesService ciudades;

    @PostMapping("/controlador1/add_ciudad")
    public void addCiudad(@RequestBody Ciudad newCiudad){
        ciudades.addCiudad(newCiudad);
    }
}
