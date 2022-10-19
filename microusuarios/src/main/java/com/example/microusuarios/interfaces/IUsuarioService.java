package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.model.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUser(String user);
	public List<UsuarioDTO> listUsuarios();
	public void agregarUsuario(Usuario usuario);

}
