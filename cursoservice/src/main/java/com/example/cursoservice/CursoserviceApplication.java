package com.example.cursoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CursoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoserviceApplication.class, args);
	}

}
