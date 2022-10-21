package com.example.micro_consumidor_resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.micro_consumidor_resttemplate.services.AnuncioService;
import com.example.micro_consumidor_resttemplate.services.UsuarioService;
import com.example.micro_consumidor_resttemplate.util.AnuncioV;
import com.example.micro_consumidor_resttemplate.util.UsuarioV;

@Controller
public class MiControlador {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired 
	AnuncioService anuncioService;
	
	@GetMapping("/formularioRegistroUsuario")
	public String formularioRegistroUsuario(Model model) {
		
		model.addAttribute("usuario", new UsuarioV());
		
		
		return "formularioRegistroUsuario";
	}
	
	@PostMapping("/registroUsuario")
	public String registroUsuario(UsuarioV usuario, Model model) {
		
		usuarioService.agregarUsuario(usuario);
		model.addAttribute("usuario", usuario);
		
		return "formularioIniciarSesion";
	}
	
	@PostMapping("/publicarAnuncio")
	public String publicarAnuncio(AnuncioV anuncio, Model model) {
		
		anuncioService.agregarAnuncio(anuncio);
		model.addAttribute("anuncios", usuarioService.listAllAnunciosByUser(anuncio.getUser()));
		
		return "anunciosByUser";
	}
	
	
	@GetMapping("/formularioIniciarSesion")
	public String formularioIniciarSesion(Model model) {
		
		model.addAttribute("usuario", new UsuarioV());
		
		return "formularioIniciarSesion";
	}
	
	@PostMapping("/inicioSesion")
	public String iniciarSesion(UsuarioV usuario, Model model) {
		
		model.addAttribute("anuncios", usuarioService.listAllAnunciosByUser(usuario.getUser()));
		model.addAttribute("anuncioV", new AnuncioV());
		return "anunciosByUser";
	}

	@GetMapping("/lista_usuarios")
	public String listUsuarios(Model model) {
		
		model.addAttribute("usuarios", usuarioService.listUsuarios());
		
		return "lista_usuarios";
	}
	
	@GetMapping("/formularioAgregarAnuncio/{user}")
	public String formularioAgregarAnuncio(@PathVariable("user") String user , 
			Model model) {
		
		AnuncioV anuncio = new AnuncioV();
		anuncio.setUser(user);
		model.addAttribute("anuncioV", anuncio);
		
		return "formularioAgregarAnuncio";
	}
	
	@GetMapping("{idUsuario}/lista_anuncios")
	public String listAllAnunciosByUser(@PathVariable("idUsuario") String idUsuario, Model model) {
		
		model.addAttribute("usuarios", usuarioService.listAllAnunciosByUser(idUsuario));
		
		return "lista_anuncios";
	}
		
	@GetMapping("/")
	public String listAllAnunciosByUser(Model model) {
		
		model.addAttribute("anuncios", anuncioService.muestraAnuncios());
		
		return "index";
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
