package com.example.microanuncios.interfaces;

import java.util.List;

import com.example.microanuncios.dto.AnuncioDto;
import com.example.microanuncios.dto.CategoriaDto;
import com.example.microanuncios.model.Categoria;

public interface ICategoriaService {
	
	public List<CategoriaDto> listAllCategorias();
	public List<AnuncioDto> listAnunciosPorCategoria(int id_categoria);
	public Categoria findById(int idCategoria);

}
