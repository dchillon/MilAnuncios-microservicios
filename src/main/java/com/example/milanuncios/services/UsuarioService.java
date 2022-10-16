package com.example.milanuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.interfaces.IUsuarioService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.model.Usuario;
import com.example.milanuncios.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	UsuarioRepository repositorio;

	@Override
	public Usuario findByUser(String user) {
		return repositorio.findById(user).orElse(null);
	}

	@Override
	public List<AnuncioDto> findAnunciosByUser(String user) {
		List<AnuncioDto> anuncios = new ArrayList<AnuncioDto>();
		Usuario u = repositorio.findById(user).orElse(null);
		for (Anuncio a : u.getAnuncios()) {
			anuncios.add(new AnuncioDto(a.getId_anuncio(), a.getId_categoria(), a.getTitulo(), a.getDescripcion(), a.getPrecio(), a.getFecha(),
								a.getLocalidad(), a.getUser()));
		}
		
		return anuncios;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		
		repositorio.save(usuario);
	}

}
