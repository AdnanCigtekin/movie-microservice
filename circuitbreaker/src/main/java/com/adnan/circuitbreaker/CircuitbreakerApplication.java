package com.adnan.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CircuitbreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitbreakerApplication.class, args);
	}

}
