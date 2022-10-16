package com.example.milanuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.milanuncios.dtos.AnuncioDto;
import com.example.milanuncios.interfaces.IAnuncioService;
import com.example.milanuncios.model.Anuncio;
import com.example.milanuncios.repository.AnuncioRepository;

@Service
public class AnuncioService implements IAnuncioService {
	
	@Autowired
	AnuncioRepository repositorio;

	@Override
	public void agregarAnuncio(Anuncio anuncio) {
		
		repositorio.save(anuncio);
	}

	@Override
	public List<AnuncioDto> listAll() {
		List<AnuncioDto> dtos = new ArrayList<AnuncioDto>();
		List<Anuncio> anuncios = (List<Anuncio>) repositorio.findAll();
		for (Anuncio anuncio : anuncios) {
			AnuncioDto dto = new AnuncioDto(anuncio.getId_anuncio(), anuncio.getId_categoria(), anuncio.getTitulo(),
					anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(), anuncio.getLocalidad(), 
					anuncio.getUser());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public Anuncio findByIdAnuncio(int idAnuncio) {
		return repositorio.findById(idAnuncio).orElse(null);
	}

	@Override
	public void borrarAnuncio(int id_anuncio) {
		
		repositorio.deleteById(id_anuncio);
	}

}
