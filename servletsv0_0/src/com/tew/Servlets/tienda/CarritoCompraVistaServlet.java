package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicaCarritoServlet
 */
@WebServlet(name = "CarritoCompraVista", urlPatterns = { "/CarritoCompraVista" })
public class CarritoCompraVistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Carrito Compra</TITLE></HEAD>");
		out.println("<BODY>");

		out.println("<FORM ACTION=\"http://localhost:8080/servletsv0_0/CarritoCompra\" METHOD=\"POST\"> ");
		out.println("<table >\r\n" + 
				"<tr>\r\n" + 
				"<td >Escoja el artículo que desea:</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<select name=\"juego\" size=\"1\">\r\n" + 
				"<option value=\"00\">blasphemous</option>\r\n" + 
				"<option value=\"11\">ligoleye</option>\r\n" + 
				"<option value=\"22\">pokemon blanco</option>\r\n" + 
				"<option value=\"33\">fernando alonso</option>\r\n" + 
				"<option value=\"44\">yakuza 0</option>\r\n" + 
				"<option value=\"55\">persona 5</option>\r\n" + 
				"<option value=\"66\">hollow knight</option>\r\n" + 
				"<option value=\"77\">amogus</option>\r\n" + 
				"<option value=\"88\">furbo con los colegas</option>\r\n" + 
				"<option value=\"99\">bloodborne en pc</option>\r\n" + 
				"</select>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td >\r\n" + 
				"<input type=\"submit\" value=\"añadir al carrito...\">\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>");
		out.println("</FORM>");
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carrito =(HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		out.println("<br>");
		out.println("Carrito:");
		for(Entry<String, Integer> e : carrito.entrySet()) {
			out.println("<br>" + String.format("Juego: %s, Cantidad: %d", e.getKey(), e.getValue()));	
		}
		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
