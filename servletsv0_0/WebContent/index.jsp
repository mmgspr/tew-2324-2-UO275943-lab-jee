<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, java.io.*, com.tew.beans.Counter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito Compra</title>
</head>
<body>
	<form action="/servletsv0_0/CarritoCompra" method="post">
		<table>
			<tr>
				<td>Escoja el artículo que desea:</td>
			</tr>
			<tr>
				<td><select name="juego" size="1">
						<option value="00">blasphemous</option>
						<option value="11">ligoleye</option>
						<option value="22">pokemon blanco</option>
						<option value="33">fernando alonso</option>
						<option value="44">yakuza 0</option>
						<option value="55">persona 5</option>
						<option value="66">hollow knight</option>
						<option value="77">amogus</option>
						<option value="88">furbo con los colegas</option>
						<option value="99">bloodborne en pc</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="añadir al carrito...">
				</td>
			</tr>
		</table>
	</FORM>
	<%		@SuppressWarnings("unchecked")
	HashMap<String, Integer> carrito =(HashMap<String, Integer>) request.getSession().getAttribute("carrito"); %>
	<br> Carrito:
	<%
	for(Map.Entry<String, Integer> e : carrito.entrySet()) { %>
	<br>
	<%=String.format("Juego: %s, Cantidad: %d", e.getKey(), e.getValue())%>
	<%}
	%>
	<% Counter contador = (Counter) application.getAttribute("contador"); %>
	

</body>
</html>