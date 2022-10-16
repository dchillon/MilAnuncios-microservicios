package com.example.milanuncios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.milanuncios.interfaces.IAnuncioService;
import com.example.milanuncios.interfaces.IUsuarioService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.model.Usuario;
import com.example.milanuncios.services.CategoriaService;
import com.example.milanuncios.util.AnuncioV;
import com.example.milanuncios.util.FormularioRegistroV;

@Controller
public class MiControlador {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IAnuncioService anuncioService;
	
	@GetMapping("categorias")
	public String muestraCategorias(Model model) {
		
		model.addAttribute("categorias", categoriaService.listAllCategorias());
		
		return "categorias";
	}
	
	@GetMapping("anunciosByCategoria/{id_categoria}")
	public String muestraAnunciosPorCategoria(@PathVariable("id_categoria") Integer id_categoria, Model model) {
		model.addAttribute("anuncios", categoriaService.listAnunciosPorCategoria(id_categoria));
		return "anunciosPorCategoria";
	}
	
	@GetMapping("formularioIniciarSesion")
	public String formularIniciarSesion(Model model) {
		model.addAttribute("formularioRegistroV", new FormularioRegistroV("",""));
		return "formularioIniciarSesion";
	}
	
	@PostMapping("inicioSesion")
	public String inicioSesion(FormularioRegistroV formularioRegistroV, Model model) {
		Usuario u = usuarioService.findByUser(formularioRegistroV.getUser());
		
		if(u == null) {
			model.addAttribute("mensaje","usuario no registrado");
			return "formularioIniciarSesion";
		}else {
			if(formularioRegistroV.getPassword().equals(u.getPassword())) {
				AnuncioV anuncioV = new AnuncioV();
				anuncioV.setUser(formularioRegistroV.getUser());
				model.addAttribute("anuncios", usuarioService.findAnunciosByUser(u.getUser()));
				model.addAttribute("formularioRegistroV", new FormularioRegistroV("",""));
				model.addAttribute("anuncioV", anuncioV);
				return "anunciosByUser";
			}else {
				model.addAttribute("mensaje", "password erronea");
				return "formularioIniciarSesion";
			}
		}

	}
	
	@GetMapping("borrarAnuncio/{id_anuncio}")
	public String borrarAnuncio(@PathVariable("id_anuncio") Integer id_anuncio, Model model) {
		Anuncio anuncio = anuncioService.findByIdAnuncio(id_anuncio);
		
		anuncioService.borrarAnuncio(id_anuncio);
		
		model.addAttribute("anuncios", usuarioService.findAnunciosByUser(anuncio.getUser()));
		model.addAttribute("formularioRegistroV", new FormularioRegistroV("",""));
		model.addAttribute("anuncioV", new AnuncioV());
		return "anunciosByUser";
	}
	
	@PostMapping("publicarAnuncio")
	public String publicarAnuncio(AnuncioV anuncioV, Model model) {
		Anuncio a = new Anuncio(0, Integer.parseInt(anuncioV.getId_categoria()), anuncioV.getTitulo(),
				anuncioV.getDescripcion(),Double.parseDouble(anuncioV.getPrecio()), anuncioV.getFecha(), anuncioV.getLocalidad(), 
				anuncioV.getUser());
		anuncioService.agregarAnuncio(a);
		
		model.addAttribute("anuncios", usuarioService.findAnunciosByUser(anuncioV.getUser()));
		model.addAttribute("formularioRegistroV", new FormularioRegistroV("",""));
		model.addAttribute("anuncioV", new AnuncioV());
		return "anunciosByUser";
	}
	
	@GetMapping("formularioRegistroUsuario")
	public String formularioRegistroUsuario(Model model) {
		model.addAttribute("formularioRegistroV", new FormularioRegistroV());
		return"formularioRegistroUsuario";
	}
	
	@PostMapping("registroUsuario")
	public String registroUsuario(FormularioRegistroV formularioRegistroV, Model model) {
		Usuario u = usuarioService.findByUser(formularioRegistroV.getUser());
		
		if(u != null) {
			model.addAttribute("mensaje","usuario ya registrado");
			return "formularioRegistroUsuario";
		}else {
			
			usuarioService.agregarUsuario(new Usuario(formularioRegistroV.getUser(), formularioRegistroV.getPassword(), formularioRegistroV.getEmail()));
			model.addAttribute("mensaje", "usuario registrado correctamente");
			return "formularioRegistroUsuario";
		}
	}

}
