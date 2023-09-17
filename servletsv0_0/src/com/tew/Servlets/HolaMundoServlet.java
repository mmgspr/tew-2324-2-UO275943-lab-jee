package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
		out.println("<BODY>");
		@SuppressWarnings("unchecked")
		Vector<String> listado = (Vector<String>)request.getSession().getAttribute("listado");
		if (listado == null){
			listado = new Vector<String>();   
		}
		if ( nombre != null ){
			out.println("<br>Hola "+nombre+"<br>");
			listado.addElement(nombre);
		}
		request.getSession().setAttribute("listado",listado);
		out.println("Bienvenido a mi primera página web!");
		out.println("<br>");
		out.println("Contigo, hoy me han visitado:<br>");
		for ( int i = 0 ; i < listado.size() ; i++ ){
			out.println("<br>"+(String)listado.elementAt(i));
		}
		out.println("<a href=\"index.html\">volver</a>");
		Integer contador= (Integer) getServletContext().getAttribute("contador");
		if ( contador == null ){
			contador = new Integer(0);
		}
		getServletContext().setAttribute("contador",new Integer(contador.intValue()+1));
		out.println("<br><br>" + contador +" visitas");
		out.println("</BODY></HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
