package com.apicadastro.apicadastro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public void configurer(HttpSecurity httpSec) throws Exception {
        System.out.println("Estou aqui ! :) ");
    }
}
