package com.example.micro_consumidor_resttemplate.util;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Anuncio")
public class AnuncioV {
	
	private String id_anuncio;
	private String id_categoria;
	private String titulo;
	private String descripcion;
	private String precio;
	private String fecha;
	private String localidad;
	private String user;
	private Categoria categoria;
	private Usuario usuario;

	
	public AnuncioV() {
		super();
	}

	public AnuncioV(String id_anuncio, String id_categoria, String titulo, String descripcion, String precio, String fecha,
			String localidad, String user) {
		super();
		this.id_anuncio = id_anuncio;
		this.id_categoria = id_categoria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
		this.localidad = localidad;
		this.user = user;
	}

	public String getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(String id_anuncio) {
		this.id_anuncio = id_anuncio;
	}

	public String getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Anuncio [id_anuncio=" + id_anuncio + ", id_categoria=" + id_categoria + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", fecha=" + fecha + ", localidad="
				+ localidad + ", user=" + user  + "]";
	}
	

}
