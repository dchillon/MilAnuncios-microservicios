package com.example.microanuncios.interfaces;

import java.util.List;

import com.example.microanuncios.dto.AnuncioDto;
import com.example.microanuncios.model.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUser(String user);
	public List<AnuncioDto> findAnunciosByUser(String user);
	public void agregarUsuario(Usuario usuario);

}
