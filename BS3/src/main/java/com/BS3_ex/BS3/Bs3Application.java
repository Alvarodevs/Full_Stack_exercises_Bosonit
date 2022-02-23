package com.BS3_ex.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs3Application {

	@Bean
	CommandLineRunner secondExecute(){
		return print -> {System.out.println("Hola desde la clase secundaria");
		};
	}

	@Bean
	CommandLineRunner thirdExecute(String ...args){
		return p -> {
			System.out.println("Soy la tercera clase");
			for (String print : args) {
				System.out.println(print);
			}
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(Bs3Application.class, args);
	}

}
