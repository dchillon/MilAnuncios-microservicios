package com.example.milanuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.dtos.CategoriaDto;
import com.example.milanuncios.interfaces.ICategoriaService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.model.Categoria;
import com.example.milanuncios.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
	
	@Autowired
	CategoriaRepository repositorio;

	@Override
	public List<CategoriaDto> listAllCategorias() {
		List<CategoriaDto> dtos = new ArrayList<CategoriaDto>();
		List<Categoria> categorias = (List<Categoria>) repositorio.findAll();
		for (Categoria categoria : categorias) {
			CategoriaDto dto = new CategoriaDto(categoria.getId_categoria(), categoria.getDescripcion());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<AnuncioDto> listAnunciosPorCategoria(int id_categoria) {
		Categoria categoria = repositorio.findById(id_categoria).orElse(null);
		List<AnuncioDto> anuncios = new ArrayList<AnuncioDto>();
		
		try {
			List<Anuncio> a = categoria.getAnuncios();
			for (Anuncio anuncio : a) {
				AnuncioDto dto = new AnuncioDto(anuncio.getId_anuncio(), anuncio.getId_categoria(),
						anuncio.getTitulo(), anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(),
						anuncio.getLocalidad(), anuncio.getUser());
				anuncios.add(dto);
			}
		}catch(Exception e) {
			
		}		
		
		return anuncios;
	}

	@Override
	public Categoria findById(int idCategoria) {
		return repositorio.findById(idCategoria).orElse(null);
	}

}
