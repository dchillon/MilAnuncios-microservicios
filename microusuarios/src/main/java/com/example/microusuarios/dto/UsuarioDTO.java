package com.example.microusuarios.dto;

public class UsuarioDTO {
	
	private String user;
	private String password;
	private String email;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String user, String password, String email) {
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

	@Override
	public String toString() {
		return "Usuario [user=" + user + ", password=" + password + ", email=" + email + "]";
	}

}
