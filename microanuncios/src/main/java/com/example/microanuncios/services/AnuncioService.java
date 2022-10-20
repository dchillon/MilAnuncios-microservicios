package com.example.microanuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microanuncios.dto.AnuncioDto;
import com.example.microanuncios.interfaces.IAnuncioService;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.repository.AnuncioRepository;

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

	@Override
	public void actualizarAnuncio(AnuncioDto anuncio) {

		Anuncio a = new Anuncio(anuncio.getId_anuncio(), anuncio.getId_categoria(), anuncio.getTitulo(),
				anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(), anuncio.getLocalidad(), 
				anuncio.getUser());
		
		repositorio.save(a);
	}

	@Override
	public List<AnuncioDto> findByIdCategoria(int id_categoria) {
		List<AnuncioDto> dtos = new ArrayList<AnuncioDto>();
		List<Anuncio> anuncios = (List<Anuncio>) repositorio.findAll();
		for (Anuncio anuncio : anuncios) {
			if(anuncio.getCategoria().getId_categoria() == id_categoria) {
				AnuncioDto dto = new AnuncioDto(anuncio.getId_anuncio(), anuncio.getId_categoria(), anuncio.getTitulo(),
						anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFecha(), anuncio.getLocalidad(), 
						anuncio.getUser());
				dtos.add(dto);
			}
			
		}
		return dtos;
	}

}
