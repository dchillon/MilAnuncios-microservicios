package com.example.micro_consumidor_resttemplate.util;

import java.util.List;


public class Usuario {
	
	private String user;
	private String password;
	private String email;
	private List<Anuncio> anuncios;

	public Usuario() {
		super();
	}

	public Usuario(String user, String password, String email) {
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
