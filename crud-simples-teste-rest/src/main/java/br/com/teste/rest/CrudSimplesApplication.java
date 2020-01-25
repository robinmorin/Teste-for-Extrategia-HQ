package br.com.teste.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.teste.rest")
public class CrudSimplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSimplesApplication.class, args);
	}

}
