package com.example.micro_consumidor_resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.micro_consumidor_resttemplate.services.UsuarioServiceImpl;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroConsumidorResttemplateApplication {
	
	public static String url = "http://microUsuarios/api/usuarios"; 

	public static void main(String[] args) {
		SpringApplication.run(MicroConsumidorResttemplateApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	public UsuarioServiceImpl getService() {
		
		return new UsuarioServiceImpl(url);
	}

}
