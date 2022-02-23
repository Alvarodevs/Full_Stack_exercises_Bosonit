package com.Spring_Boot_ex.BS2_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs23Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs23Application.class, args);
	}

	@Bean(name="b1")
		PersonaService getPersonaService1(){
			return new PersonaServiceImp("Paco", "La Isla", 34);
		}
	@Bean(name="b2")
	PersonaService getPersonaService2(){
		return new PersonaServiceImp("Antonio", "Cadiz", 87);
		}
	@Bean(name="b3")
	PersonaService getPersonaService3(){
		return new PersonaServiceImp("Marta", "Jaen", 38);
		}
}
