<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Esta era una prueba en el caso de que recogieramos los datos del 
nuevo evento como tipo session, al final lo descarte per en el caso de que queramos podremos usarlo de neuvo. -->
<%List<Evento> lista = (List<Evento>)session.getAttribute("listaeventos"); %>
<% for (Evento eve: lista) {%>
<p><%=eve %></p>
<%} %>
</body>
</html>