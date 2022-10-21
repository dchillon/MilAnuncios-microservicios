package com.example.micro_consumidor_resttemplate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.micro_consumidor_resttemplate.util.Anuncio;
import com.example.micro_consumidor_resttemplate.util.AnuncioV;


public class AnuncioServiceImpl implements AnuncioService {

	public String url;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public AnuncioServiceImpl(String url) {
		super();
		this.url = url;
	}
	
	@Override
	public Integer agregarAnuncio(AnuncioV anunciov) {
		Integer response = restTemplate.postForObject(url + "/add_anuncio/", anunciov, Integer.class);
		return response;
	}

	@Override
	public List<Anuncio> muestraAnuncios() {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		
		anuncios = restTemplate.getForObject(url + "/lista_anuncios", List.class);
		
		return anuncios;
	}

	@Override
	public Anuncio getAnuncioById(Integer idAnuncio) {
		Anuncio anuncio = null;
		
		anuncio = restTemplate.getForObject(url + "/"+idAnuncio, Anuncio.class);
		
		return anuncio;
	}

	@Override
	public Anuncio getAnuncioByCategoria(Integer idCategoria) {
		Anuncio anuncio = null;
		
		anuncio = restTemplate.getForObject(url + "/"+idCategoria, Anuncio.class);
		
		return anuncio;
	}

	@Override
	public Integer borrarAnuncioById(Integer idAnuncio) {
		Integer response = restTemplate.postForObject(url + "/borrar_anuncio_by_id/", idAnuncio, Integer.class);
		return response;
	}

	@Override
	public Integer actualizarAnuncio(AnuncioV anuncio) {
		Integer response = restTemplate.postForObject(url + "/actualizar_anuncio/", anuncio, Integer.class);
		return response;
	}

}
