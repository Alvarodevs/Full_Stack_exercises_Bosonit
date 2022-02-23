package com.Spring_Boot_ex.BS2_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class Controlador2 {

    @Autowired ListaDeCiudadesService ciudades;

    @GetMapping("/controlador2/getCiudad")
        public ArrayList<Ciudad> getCiudad(){
            return ciudades.getCiudades();
        }
}
