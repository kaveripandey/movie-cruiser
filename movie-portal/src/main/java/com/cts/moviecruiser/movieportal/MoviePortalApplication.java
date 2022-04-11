package com.cts.moviecruiser.movieportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoviePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviePortalApplication.class, args);
	}

}
