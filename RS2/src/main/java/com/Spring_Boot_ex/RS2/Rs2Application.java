package com.Spring_Boot_ex.RS2;

import com.Spring_Boot_ex.RS2.objetos.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = {"com.Spring_Boot_ex.RS2.controladores", "com.Spring_Boot_ex.RS2.objetos"})
public class Rs2Application {

	public static void main(String[] args) {
		SpringApplication.run(Rs2Application.class, args);
	}

}
