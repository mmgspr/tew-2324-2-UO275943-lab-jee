package com.tew.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="error")
@SessionScoped
public class BGerror implements Serializable {
	private static final long serialVersionUID = 55557L;


	private String vista;
	private String metodo;
	private String clase;

	private Exception ex;
	
	public BGerror() {
		this.setVista(null);
		this.setMetodo(null);
		this.setClase(null);
		this.setEx(null);
	}

	
	public void initError(String vista, Exception e) {
		this.setVista(vista);
		this.setClase(e.getStackTrace()[0].getClassName());
		this.setMetodo(e.getStackTrace()[0].getMethodName());
		this.setEx(e);
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
