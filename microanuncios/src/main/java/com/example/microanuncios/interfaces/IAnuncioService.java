package com.example.microanuncios.interfaces;

import java.util.List;

import com.example.microanuncios.dto.AnuncioDto;
import com.example.microanuncios.model.Anuncio;

public interface IAnuncioService {
	
	public void agregarAnuncio(Anuncio anuncio);
	public List<AnuncioDto> listAll();
	public Anuncio findByIdAnuncio(int idAnuncio);
	public void borrarAnuncio(int id_anuncio);
	public void actualizarAnuncio(AnuncioDto anuncio);

}
