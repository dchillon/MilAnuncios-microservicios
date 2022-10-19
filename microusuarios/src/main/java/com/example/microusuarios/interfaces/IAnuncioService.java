package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.AnuncioDTO;

public interface IAnuncioService {

	public List<AnuncioDTO> listAllAnunciosByUser(String idUsuario);

}
