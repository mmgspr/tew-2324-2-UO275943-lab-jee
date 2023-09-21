package com.tew.Servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nombre = (String) request.getParameter("NombreUsuario");

		@SuppressWarnings("unchecked")
		Vector<String> listado = (Vector<String>)request.getSession().getAttribute("listado");
		if (listado == null){
			listado = new Vector<String>();   
		}
		if ( nombre != null ){
			request.getSession().setAttribute("nombre", nombre);
			listado.addElement(nombre);
		}
		request.getSession().setAttribute("listado",listado);
		Integer contador= (Integer) getServletContext().getAttribute("contador");
		if ( contador == null ){
			contador = new Integer(0);
		}
		getServletContext().setAttribute("contador",new Integer(contador.intValue()+1));
		RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("HolaMundoVista");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
