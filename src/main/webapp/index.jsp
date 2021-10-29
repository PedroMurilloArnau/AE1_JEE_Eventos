<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@page import="modelo.daos.EventoDaolmpl"%>
<%@page import="modelo.daos.IntEventoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
font-family: Verdana;
color:rgb(12, 12, 136); 
}
h1{
font-size:20px;
color:rgb(93, 24, 121); 
}
/*nav{
    text-align: center;
}*/
ul{
	 display: inline-block;

}
li{
	padding:20px;
    float:left;
	list-style:none;
	border: 2px rgb(116, 199, 201) solid;
	text-align:center;
}
li.houver{
	 background:2px rgb(116, 199, 201) solid;
}
a{
	text-decoration:none;
}
a#ned{
	padding:5px;
	border:2px rgb(116, 199, 201) solid;
}
table{
border: 5px rgb(116, 199, 201) solid;
}
td{
border: 5px rgb(116, 199, 201) solid;
}
th{
background-color: rgb(116, 199, 201);
}
</style>
</head>
<body>
<!-- Mediante el sigueiente scriplets recogeremos todos los datos enviados desde los servlets tanto de "Homecontroller" y "GestionEventos. -->
<%
/*Creamos una lista de Eventos, mediante un "casting" transformamos
el String a modo lista.*/
	List<Evento> lista = (List<Evento>)request.getAttribute("listaeventos");
	
	String mensaje = (String)request.getAttribute("mensaje");
%>

<nav>
<ul>
<li>Tipos</li>
<li>Eventos</li>
<li>Usuarios</li>
<li id="actual">Eventos/tipo</li>
<li>Login</li>
<li>Registro</li>
<li>Salir</li>
</ul>
</nav>
<a href="gestion?opcion=activos">Listado de Eventos Activos</a>
<br/>
<br/>

<div id="2">
<a id="ned" href="nuevoEvento.jsp">Nuevo evento</a>
<br/></br>
<br/>
<h2><%= (mensaje != null)?mensaje : "" %></h2>
<table>
<tr>
<th>Id</th>
<th>Nombre</th>
<th>Precio</th>
<th>Estado</th>
<th colspan="3">Opciones</th>
</tr>
<tr>
<% for (Evento eve: lista){ %>
<tr>
<td><%=eve.getIdevento() %></td>
<td><%=eve.getNombre() %></td>
<td><%=eve.getPrecio() %></td>
<td><%=eve.getEstado() %></td>

<!-- Mediante el enlace mandamos la dupla de datos al constructor,
mediante el metodo "getIdevento()" de la clase Evento obtenemos su id. -->

<td><a href="gestion?opcion=editar&id=<%=eve.getIdevento() %>">Editar</a></td>
<td><a href="gestion?opcion=eliminar&id=<%=eve.getIdevento() %>">Eliminar</a></td>
<td><a href="gestion?opcion=cancelar&id=<%=eve.getIdevento() %>">Cancelar</a></td>
</tr>
<%} %>
</table>

</body>
</html>