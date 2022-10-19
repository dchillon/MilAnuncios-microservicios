package com.example.microusuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.dto.AnuncioDTO;
import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IAnuncioService;
import com.example.microusuarios.interfaces.IUsuarioService;
import com.example.microusuarios.model.Usuario;


@RestController
@RequestMapping("/api/usuarios")
public class MiControlador {
	
	@Autowired
	IUsuarioService usuariosService;
	
	@Autowired
	IAnuncioService anuncioService;
	
	@GetMapping("/lista_usuarios")
	public ResponseEntity<List<UsuarioDTO>> muestraUsuarios(Model model){
	
		if(usuariosService.listUsuarios().size() == 0) {
		return ResponseEntity.noContent().build();  
		}

		return ResponseEntity.ok(usuariosService.listUsuarios());
	}
	
	@GetMapping("/{id_usuario}/lista_anuncios")
	public ResponseEntity<List<AnuncioDTO>> muestraAnunciosUsuario(Model model,
			@PathVariable("id_usuario") String idUsuario){
		
		if(anuncioService.listAllAnunciosByUser(idUsuario).size() == 0) {
			return ResponseEntity.noContent().build();  
		}
 
		return ResponseEntity.ok(anuncioService.listAllAnunciosByUser(idUsuario));
	}
	
	@PostMapping("/add_usuario")
	public ResponseEntity<Integer> add_anuncio(@RequestBody UsuarioDTO usuarioDTO ){
		
		if(usuariosService.findByUser(usuarioDTO.getUser()) == null) {
			
			Usuario u = new Usuario(usuarioDTO.getUser(), 
					usuarioDTO.getPassword(), usuarioDTO.getEmail());
			
			usuariosService.agregarUsuario(u);
			return ResponseEntity.ok(1);
		}
		else
			return ResponseEntity.ok(0);
	}
}
