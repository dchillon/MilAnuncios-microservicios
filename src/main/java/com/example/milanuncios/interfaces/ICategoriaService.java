package com.example.milanuncios.interfaces;

import java.util.List;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.dtos.CategoriaDto;
import com.example.milanuncios.model.Categoria;

public interface ICategoriaService {
	
	public List<CategoriaDto> listAllCategorias();
	public List<AnuncioDto> listAnunciosPorCategoria(int id_categoria);
	public Categoria findById(int idCategoria);

}
