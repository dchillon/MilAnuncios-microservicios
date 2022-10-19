package com.example.micro_consumidor_resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.micro_consumidor_resttemplate.services.UsuarioService;
import com.example.micro_consumidor_resttemplate.util.UsuarioV;

@Controller
public class MiControlador {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/lista_usuarios")
	public String listUsuarios(Model model) {
		
		model.addAttribute("usuarios", usuarioService.listUsuarios());
		
		return "lista_usuarios";
	}
	
	@GetMapping("{idUsuario}/lista_anuncios")
	public String listAllAnunciosByUser(@PathVariable("idUsuario") String idUsuario, Model model) {
		
		model.addAttribute("usuarios", usuarioService.listAllAnunciosByUser(idUsuario));
		
		return "lista_anuncios";
	}
		
	@PostMapping("add_usuario")
	public String agregarUsuario(UsuarioV usuario_v, Model model) {
		
		Integer response=usuarioService.agregarUsuario(usuario_v);
		if(response==0) {
			model.addAttribute("mensaje","alta realizada correctamente");
		}else {
			model.addAttribute("mensaje","usuario ya existe");
		}
		return "add_usuario";
	}


}
