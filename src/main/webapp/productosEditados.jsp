<%@page import="modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Evento evento = (Evento)request.getAttribute("evento");%>
	<p>Descripcion : Es una <%=evento.getNombre() %>, de tipo <%= evento.getDescripcion()  %>, con un precio de <%= evento.getPrecio() %>e</p>
</body>
</html>