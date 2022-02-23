package com.Spring_Boot_ex.BS2_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs22Application {

	public static void main(String[] args) {

		SpringApplication.run(Bs22Application.class, args);
	}

	@Bean
	ListaDeCiudadesService getListaDeCiudadesService(){
		return new ListaDeCiudadesServiceImp();
	}
}
