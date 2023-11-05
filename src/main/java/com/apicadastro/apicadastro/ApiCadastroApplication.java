package com.apicadastro.apicadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroApplication.class, args);
	}

}
