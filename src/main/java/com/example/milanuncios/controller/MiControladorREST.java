package com.example.milanuncios.controller;

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

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.dtos.CategoriaDto;
import com.example.milanuncios.interfaces.IAnuncioService;
import com.example.milanuncios.interfaces.ICategoriaService;
import com.example.milanuncios.interfaces.IUsuarioService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.model.Categoria;

@RestController
@RequestMapping("/api/milanuncios")
public class MiControladorREST {
	
	@Autowired
	IAnuncioService anunciosService;
	
	@Autowired
	ICategoriaService categoriasService;
	
	@Autowired
	IUsuarioService usuariosService;
	
	@GetMapping("/anuncios")
	public ResponseEntity<List<AnuncioDto>> muestraAnuncios(Model model){
		
		if(anunciosService.listAll().size() == 0) {
			return ResponseEntity.noContent().build();  
		}
 
		return ResponseEntity.ok(anunciosService.listAll());
	}

	@PostMapping("/add_anuncio")
	public ResponseEntity<Integer> add_anuncio(@RequestBody AnuncioDto anunciodto ){		
		if(categoriasService.findById(anunciodto.getId_categoria()) == null) {
			return ResponseEntity.ok(1);
		}
		if(usuariosService.findByUser(anunciodto.getUser()) == null) {
			return ResponseEntity.ok(1);
		}
		Anuncio anuncio = anunciosService.findByIdAnuncio(anunciodto.getId_anuncio());
		if(anuncio == null) {
			Anuncio dto = new Anuncio(anuncio.getId_anuncio(), anuncio.getId_categoria(), anuncio.getTitulo(),
					anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(), anuncio.getLocalidad(), 
					anuncio.getUser());
			anunciosService.agregarAnuncio(dto);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}

	@GetMapping("/anuncios/{idAnuncio}")
	public ResponseEntity<AnuncioDto> getAnuncioById(@PathVariable("idAnuncio") Integer idAnuncio){
		Anuncio anuncio = anunciosService.findByIdAnuncio(idAnuncio);
		if(anuncio == null) {
			return ResponseEntity.noContent().build();  
		}
		AnuncioDto a = new AnuncioDto(anuncio.getId_anuncio(), anuncio.getId_categoria(), anuncio.getTitulo(),
				anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(), anuncio.getLocalidad(), 
				anuncio.getUser());
		
		return ResponseEntity.ok(a);    
	}
	
	@GetMapping("/categorias/{idCategoria}")
	public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable("idCategoria") Integer idCategoria){
		Categoria categoria = categoriasService.findById(idCategoria);
		if(categoria == null) {
			return ResponseEntity.noContent().build();  
		}
		CategoriaDto dto = new CategoriaDto(categoria.getId_categoria(), categoria.getDescripcion());
		
		return ResponseEntity.ok(dto);    
	}

}
