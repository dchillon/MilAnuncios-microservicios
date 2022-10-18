package com.example.microanuncios.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microanuncios.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
