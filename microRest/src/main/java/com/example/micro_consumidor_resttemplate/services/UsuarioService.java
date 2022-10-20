package com.example.micro_consumidor_resttemplate.services;

import java.util.List;

import com.example.micro_consumidor_resttemplate.util.Anuncio;
import com.example.micro_consumidor_resttemplate.util.Usuario;
import com.example.micro_consumidor_resttemplate.util.UsuarioV;

public interface UsuarioService {
	
	List<Anuncio> listAllAnunciosByUser(String idUsuario);
	List<Usuario> listUsuarios();
	Integer agregarUsuario(UsuarioV usuario);
	

}
