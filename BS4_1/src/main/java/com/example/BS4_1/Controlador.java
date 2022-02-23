package com.example.BS4_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@PropertySource({"classpath:application.properties", "classpath:miconfiguracion.properties"})
@RestController
public class Controlador {

    @Autowired
    Properties properties;

    @Value("${valor1}")
    public String valor1;
    @Value("${valor2}")
    public String valor2;
    @Value("${url}")
    private String url;
    @Value("${password}")
    private String password;

    @GetMapping("parametros")
    public String getParametros(){
        return "Url: " + url + " Password: " + password;
    }
    @GetMapping
    public String getValores(){
        return valor1 + " " + valor2;
    }

    @GetMapping("miconfiguracion")
    public String getMiConfiguracion(){
        return properties.toString();
    }

    @PostConstruct
    public void startWithVariables(){
        System.out.println(valor1);
        System.out.println(valor2);
    }
}
