package com.etiya.proje3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



/**
 * @author Asiye Sarıbulak
 * @since 02.08.2022
 */
@SpringBootApplication
@EnableJpaRepositories


public class Proje3Application {

	public static void main(String[] args) {

		SpringApplication.run(Proje3Application.class, args);


	}




}

