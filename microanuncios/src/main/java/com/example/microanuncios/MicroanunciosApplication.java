package com.example.microanuncios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroanunciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroanunciosApplication.class, args);
	}

}
