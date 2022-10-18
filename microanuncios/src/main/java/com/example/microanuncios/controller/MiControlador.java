package com.example.microanuncios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microanuncios.dto.AnuncioDto;
import com.example.microanuncios.interfaces.IAnuncioService;
import com.example.microanuncios.interfaces.ICategoriaService;
import com.example.microanuncios.interfaces.IUsuarioService;
import com.example.microanuncios.model.Anuncio;


@RestController
@RequestMapping("/api/anuncios")
public class MiControlador {
	

	@Autowired
	IAnuncioService anunciosService;
	
	@Autowired
	ICategoriaService categoriasService;
	
	@Autowired
	IUsuarioService usuariosService;

		
	@GetMapping("/lista_anuncios")
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
			Anuncio dto = new Anuncio(anunciodto.getId_anuncio(), anunciodto.getId_categoria(), anunciodto.getTitulo(),
					anunciodto.getDescripcion(), anunciodto.getPrecio(), anunciodto.getFecha(), anunciodto.getLocalidad(), 
					anunciodto.getUser());
			anunciosService.agregarAnuncio(dto);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}

	@GetMapping("/{idAnuncio}")
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
	
	@DeleteMapping("/borrar_anuncio_by_id/{idAnuncio}")
	public ResponseEntity<Integer> borrarAnuncioById(@PathVariable("idAnuncio") Integer idAnuncio){
		
		if(anunciosService.findByIdAnuncio(idAnuncio) == null) {
			return ResponseEntity.ok(1);
		}
		
		anunciosService.borrarAnuncio(idAnuncio);
		return ResponseEntity.ok(0);
	}
	
	@PutMapping("/actualizar_anuncio")
	public ResponseEntity<Integer> actualizarAnuncio(@RequestBody AnuncioDto dto){
		Anuncio a = anunciosService.findByIdAnuncio(dto.getId_anuncio());
		if(a == null) {
			return ResponseEntity.ok(1);
		}else {
			anunciosService.actualizarAnuncio(dto);
			return ResponseEntity.ok(0);
		}
	}

}
