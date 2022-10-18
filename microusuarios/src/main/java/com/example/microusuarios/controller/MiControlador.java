package com.example.microusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.interfaces.IUsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class MiControlador {
	
	@Autowired
	IUsuarioService usuariosService;
	

}
