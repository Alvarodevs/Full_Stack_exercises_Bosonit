package com.example.BS4_1;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties
@PropertySource("miconfiguracion.properties")

public class Properties {

    private String valor2,valor1;

    public String toString() {
        return "Properties: " + "valor1 = " + valor1 + ", valor2 = " + valor2;
    }
}
