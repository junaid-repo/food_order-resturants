package com.food.resturants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class ResturantsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResturantsApplication.class, args);
	}

}
