package com.kevin.microservices.carrito_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarritoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoMicroserviceApplication.class, args);
	}

}
