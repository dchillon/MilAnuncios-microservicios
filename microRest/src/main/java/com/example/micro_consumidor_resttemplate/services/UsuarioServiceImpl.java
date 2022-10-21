package com.example.micro_consumidor_resttemplate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.micro_consumidor_resttemplate.util.Anuncio;
import com.example.micro_consumidor_resttemplate.util.Usuario;
import com.example.micro_consumidor_resttemplate.util.UsuarioV;

public class UsuarioServiceImpl implements UsuarioService {
	
	public String url;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public UsuarioServiceImpl(String url) {
		super();
		this.url = url;
	}
	
	@Override
	public List<Usuario> listUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = restTemplate.getForObject(url + "/lista_usuarios", List.class);
		
		return usuarios;
	}
	
	@Override
	public List<Anuncio> listAllAnunciosByUser(String idUsuario) {

		List<Anuncio> productos = null;
		
		productos = restTemplate.getForObject(url + "/"+idUsuario+"/lista_anuncios", List.class);
		
		return productos;
	}

	@Override
	public Integer agregarUsuario(UsuarioV usuario) {
		Integer response = restTemplate.postForObject(url + "/add_usuario/", usuario, Integer.class);
		return response;
		
	}

}
