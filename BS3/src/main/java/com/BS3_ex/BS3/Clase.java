package com.BS3_ex.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Clase {

    @PostConstruct
    void execute(){
        System.out.println("Hola desde la clase inicial");
    }
}
