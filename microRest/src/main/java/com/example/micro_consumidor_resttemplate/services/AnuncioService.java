package com.example.micro_consumidor_resttemplate.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.micro_consumidor_resttemplate.util.Anuncio;
import com.example.micro_consumidor_resttemplate.util.AnuncioV;

public interface AnuncioService {
	
	Integer agregarAnuncio(AnuncioV anunciov);
	List<Anuncio> muestraAnuncios();
	Anuncio getAnuncioById(Integer idAnuncio);
	Anuncio getAnuncioByCategoria(Integer idCategoria);
	Integer borrarAnuncioById(Integer idAnuncio);
	Integer actualizarAnuncio(@RequestBody AnuncioV anuncio);
}
