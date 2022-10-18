package com.example.microanuncios.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microanuncios.model.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Integer>{

}
