package com.example.micro_consumidor_resttemplate.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Usuario")
public class UsuarioV {
	
	private String user;
	private String password;
	private String email;
	private List<Anuncio> anuncios;

	public UsuarioV() {
		super();
	}

	public UsuarioV(String user, String password, String email) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	@Override
	public String toString() {
		return "Usuario [user=" + user + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
