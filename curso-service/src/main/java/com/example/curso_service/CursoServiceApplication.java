package com.example.curso_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.curso_service.client")
public class CursoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServiceApplication.class, args);
	}

}
