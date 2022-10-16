package com.example.milanuncios.util;

public class FormularioRegistroV {
	
	private String user;
	private String password;
	private String email;


	public FormularioRegistroV() {
		super();
		
	}

	public FormularioRegistroV(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	

	public FormularioRegistroV(String user, String password, String email) {
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


	@Override
	public String toString() {
		return "FormularioRegistroV [user=" + user + ", passsword=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
