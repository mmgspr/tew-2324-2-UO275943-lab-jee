<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hola mundo!</title>
</head>
<body>
	<%
		if (request.getParameter("NombreUsuario") != null) {
	%>
	<h1>
		Hola
		<%=request.getParameter("NombreUsuario")%>!
	</h1>
	<br>
	<%
		}
	%>
	<h1>Bienvenido a mi primera p�gina web!</h1>
</body>
</html>