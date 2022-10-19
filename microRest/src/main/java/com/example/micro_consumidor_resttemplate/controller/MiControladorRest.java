package com.example.micro_consumidor_resttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_consumidor_resttemplate.services.UsuarioService;
import com.example.micro_consumidor_resttemplate.util.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class MiControladorRest {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/lista_usuarios")
	public ResponseEntity<List<Usuario>> listUsuarios(){
		
		if(usuarioService.listUsuarios().size() == 0) {
			return ResponseEntity.noContent().build();  //envia codigo 204
		}
		
		return ResponseEntity.ok(usuarioService.listUsuarios());    //envia codigo 200
	}

}
