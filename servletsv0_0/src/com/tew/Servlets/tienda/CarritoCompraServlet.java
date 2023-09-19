package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet(name = "CarritoCompra", urlPatterns = { "/CarritoCompra" })
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carrito =(HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if(carrito == null) {
			carrito = new HashMap<String, Integer>();
		}
		String juego = request.getParameter("juego");
		Integer cantidad = (Integer) carrito.get(juego);
		if(cantidad == null) {
			cantidad = new Integer(0);
		}
		if(juego!=null) {
			carrito.put(juego,  cantidad.intValue() + 1);
		}

		request.getSession().setAttribute("carrito", carrito);
		RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("CarritoCompraVista");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
