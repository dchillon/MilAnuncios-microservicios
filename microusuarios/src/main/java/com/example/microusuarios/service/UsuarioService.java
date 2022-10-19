package com.example.microusuarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;
import com.example.microusuarios.model.Usuario;
import com.example.microusuarios.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	UsuarioRepository repositorio;

	@Override
	public Usuario findByUser(String user) {
		return repositorio.findById(user).orElse(null);
	}

	@Override
	public List<UsuarioDTO> listUsuarios() {
		List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = (List<Usuario>) repositorio.findAll();
		for (Usuario u : usuarios) {
			UsuarioDTO dto = new UsuarioDTO(u.getUser(), u.getPassword(), 
					u.getEmail());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		repositorio.save(usuario);
	}

}
