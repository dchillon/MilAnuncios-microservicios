package com.example.microusuarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.AnuncioDTO;
import com.example.microusuarios.interfaces.IAnuncioService;
import com.example.microusuarios.model.Anuncio;
import com.example.microusuarios.repository.AnuncioRepository;

@Service
public class AnuncioService implements IAnuncioService {
	
	@Autowired
	AnuncioRepository repositorio;

	@Override
	public List<AnuncioDTO> listAllAnunciosByUser(String idUsuario)
	{
		List<AnuncioDTO> dtos = new ArrayList<AnuncioDTO>();
		List<Anuncio> anuncios = (List<Anuncio>) repositorio.findAll();
		
		for (Anuncio anuncio : anuncios) {
			if(anuncio.getUser().equals(idUsuario)) {
			AnuncioDTO dto = new AnuncioDTO(
					anuncio.getId_anuncio(), anuncio.getId_categoria(), 
					anuncio.getTitulo(), anuncio.getDescripcion(), 
					anuncio.getPrecio(), anuncio.getFecha(), 
					anuncio.getLocalidad(),  anuncio.getUser());
			
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
