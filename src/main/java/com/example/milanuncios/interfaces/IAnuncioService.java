package com.example.milanuncios.interfaces;

import java.util.List;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.model.Anuncio;

public interface IAnuncioService {
	
	public void agregarAnuncio(Anuncio anuncio);
	public List<AnuncioDto> listAll();
	public Anuncio findByIdAnuncio(int idAnuncio);
	public void borrarAnuncio(int id_anuncio);

}
