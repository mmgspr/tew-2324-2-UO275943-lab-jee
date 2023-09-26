package com.tew.model;

public class ErrorDTO {

	private String vista;
	private String metodo;
	private String clase;

	private Exception ex;
	
	public ErrorDTO() {
		setVista(null);
		setMetodo(null);
		setClase(null);
		setEx(null);
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

}
