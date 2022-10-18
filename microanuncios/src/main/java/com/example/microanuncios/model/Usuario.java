package com.example.microanuncios.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@Column(name = "user")
	private String user;
	@Column(name = "password")
	private String password;
	@Column(name= "email")
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName = "user")
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
