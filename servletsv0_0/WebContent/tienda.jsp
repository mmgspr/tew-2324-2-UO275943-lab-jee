<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi tienda</title>
</head>
<body>
	<h1>Tienda Virtual</h1>
	<br>
	<form action="tienda.jsp" method="post">
		<br>
		<table>
			<tr>
				<td>escoja el art�culo que desea:</td>
			</tr>
			<tr>
				<td><select name="producto" size="1">
						<option value="010">la trampa</option>
						<option value="345">los p�jaros</option>
						<option value="554">matrix reloaded</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="a�adir al carrito...">
				</td>
			</tr>
		</table>
	</form>
	<%
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
		}
		String producto = request.getParameter("producto");
		if (producto != null) {
			Integer cantidad = (Integer) carrito.get(producto);
			if (cantidad == null)
				cantidad = new Integer(1);
			else
				cantidad = new Integer(cantidad.intValue() + 1);
			carrito.put(producto, cantidad);
		}
		request.getSession().setAttribute("carrito", carrito);
	%>
	<br>
	<br>
	<H2>Carrito de la compra</h2>
	<br>
	<ul>
		<c:forEach var="entry" items="${carrito}">
			<li><c:out
					value="Del producto ${entry.key}, ${entry.value} unidades" /></li>
		</c:forEach>
	</ul>
	<br>
	<%
		Integer contador = (Integer) application.getAttribute("contador");
		if (contador == null) {
			contador = new Integer(0);
		}
		application.setAttribute("contador", new Integer(contador.intValue() + 1));
	%>
	<%=contador%>
	visitas
</body>
</html>