package com.example.milanuncios.interfaces;

import java.util.List;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.model.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUser(String user);
	public List<AnuncioDto> findAnunciosByUser(String user);
	public void agregarUsuario(Usuario usuario);

}
