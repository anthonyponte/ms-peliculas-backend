package com.anthonyponte.peliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPeliculasApplication.class, args);
	}

}
