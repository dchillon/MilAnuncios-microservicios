package com.example.milanuncios;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.milanuncios.interfaces.IAnuncioService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.repository.AnuncioRepository;

@SpringBootTest
public class TestAnuncios {
	
	@Autowired
	AnuncioRepository anunciorepository;
	
	@Autowired
	IAnuncioService anuncioservice;
	
	@Test
	void contextLoads() {
		assertThat(anunciorepository).isNotNull();
		assertThat(anuncioservice).isNotNull();
	}
	
	@Test
	void pruebaAdd() {
		int numAnuncios = anuncioservice.listAll().size();
		
		Anuncio a = new Anuncio(0, 1, "iphoneX", "iphone mal estado pero barato", 150, "2022-10-10", "Langreo", "dchillon");
		
		anuncioservice.agregarAnuncio(a);
		
		int numAnunciosFinal = anuncioservice.listAll().size();
		
		Assertions.assertThat(numAnuncios).isEqualTo(numAnunciosFinal);

		
	}


}
