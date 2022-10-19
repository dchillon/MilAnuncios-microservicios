package com.example.microusuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.microusuarios.dto.AnuncioDTO;
import com.example.microusuarios.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	@Query("SELECT * "
			+ "FROM Anuncio "
			+ "WHERE a.user = ?1")
	public List<AnuncioDTO> listAllAnunciosByUer(String idUsuario);
	
}
