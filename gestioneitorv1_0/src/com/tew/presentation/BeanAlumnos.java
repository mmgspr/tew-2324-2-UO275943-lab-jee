package com.tew.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.tew.business.AlumnosService;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;
import com.tew.model.ErrorDTO;

public class BeanAlumnos implements Serializable{
	private static final long serialVersionUID = 55555L;
	// Se añade este atributo de entidad para recibir el alumno concreto seleccionado
	// de la tabla o de un formulario.
	// Es necesario inicializarlo para que al entrar desde el formulario de
	// AltaForm.xhtml se puedan dejar los valores en un objeto existente.
	@ManagedProperty(value="#{alumno}")
	private BeanAlumno alumno;
//	private ErrorDTO error = new ErrorDTO();
	
	@ManagedProperty(value="#{error}")
	private BGerror error;

	public BGerror getError() {
		return error;
	}

	public void setErr(BGerror error) {
		this.error = error;
	}

//	public ErrorDTO getError() {
//		return error;
//	}
//
//	public void setError(ErrorDTO error) {
//		this.error = error;
//	}

	private Alumno[] alumnos = null;

	public BeanAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(BeanAlumno alumno) {
		this.alumno = alumno;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos =  alumnos;
	}

	public void iniciaAlumno(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//Obtenemos el archivo de propiedades correspondiente al idioma que
		//esta seleccionado y que viene envuelto en facesContext
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msgs");
		alumno.setId(null);
		alumno.setIduser(bundle.getString("valorDefectoUserId"));
		alumno.setNombre(bundle.getString("valorDefectoNombre"));
		alumno.setApellidos(bundle.getString("valorDefectoApellidos"));
		alumno.setEmail(bundle.getString("valorDefectoCorreo"));
	}

	public String listado() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			// Asi le damos información a toArray para poder hacer el casting a Alumno[]
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			error.initError("Listado", e);
			return "error";
		}
	}



	public String salva() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			//Salvamos o actualizamos el alumno segun sea una operacion de alta o de edición
			if (alumno.getId() == null) {
				service.saveAlumno(alumno);
			}
			else {
				service.updateAlumno(alumno);
			}
			//Actualizamos el javabean de alumnos inyectado en la tabla
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			error.initError("altaForm", e);
			return "error";
		}
	}

	public String baja(Alumno alumno) {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a través de la factoría
			service = Factories.services.createAlumnosService();
			//Eliminamos el alumno
			service.deleteAlumno(alumno.getId());
			//Actualizamos el javabean de alumnos inyectado en la tabla
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			error.initError("Listado", e);
			return "error";
		}
	}

	@PostConstruct
	public void init() {
		System.out.println("BeanAlumnos - PostConstruct");
		//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
		alumno = (BeanAlumno)
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new
						String("alumno"));
		//si no existe lo creamos e inicializamos
		if (alumno == null) {
			System.out.println("BeanAlumnos - No existia");
			alumno = new BeanAlumno();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "alumno",
					alumno);
		}
		
		error = (BGerror)
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new
						String("error"));
		//si no existe lo creamos e inicializamos
		if (error == null) {
			System.out.println("BGError - No existia");
			error = new BGerror();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "error",
					error);
		}
	}
	@PreDestroy
	public void end() {
		System.out.println("BeanAlumnos - PreDestroy");
	}
}