package com.example.microusuarios.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microusuarios.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
