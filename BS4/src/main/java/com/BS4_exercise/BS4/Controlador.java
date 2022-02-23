package com.BS4_exercise.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controlador {

    @Autowired
    VariableProperties varproperties;

    @Autowired
    VariableYML yml_properties;

    @GetMapping("/valores")
    public String getAllValores(){
        return "Valor de var1 es: " + varproperties.getVar1() + ", valor de var 2 es: " + varproperties.getVar2();
    }

    @GetMapping("/var3")
    public String getValor3(){
        return "El valor de var3 es: " + varproperties.getVar3();
    }

    @GetMapping("/yml_valores")
    public String getYmlValores(){
        return "Valor de var1 desde YML es: " + yml_properties.getVar1() + ", valor de var2 es: " + yml_properties.getMy_var2();
    }

    @GetMapping("yml_var3")
    public String getVar3Yml(){
        return "Valor de var3 desde Yml es: " + Optional.ofNullable(yml_properties.getVar3()).orElse("var3 no tiene valor");
    }
}
