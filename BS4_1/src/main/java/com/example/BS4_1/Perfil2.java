package com.example.BS4_1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("perfil2")
@Component
public class Perfil2 implements Perfiles {
  String perfil = "perfil2";

  @Override
  @GetMapping("/perfil")
  public String miFuncion() {
    return "Este es el " + perfil;
  }
}