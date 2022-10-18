package com.example.microanuncios.dto;

public class AnuncioDto {
	
	private int id_anuncio;
	private int id_categoria;
	private String titulo;
	private String descripcion;
	private double precio;
	private String fecha;
	private String localidad;
	private String user;
	
	
	
	public AnuncioDto() {
		super();
		
	}


	public AnuncioDto(int id_anuncio, int id_categoria, String titulo, String descripcion, double precio, String fecha,
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


	public int getId_anuncio() {
		return id_anuncio;
	}


	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}


	public int getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(int id_categoria) {
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
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



	@Override
	public String toString() {
		return "AnuncioDto [id_anuncio=" + id_anuncio + ", id_categoria=" + id_categoria + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", fecha=" + fecha + ", localidad="
				+ localidad + ", user=" + user + ", descripcionCategoria=" + "]";
	}
	
	

}
