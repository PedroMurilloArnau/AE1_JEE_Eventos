<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Creamos un jsp de tipo formulario que le envía el resultado a "GestionEventos". -->
<h2>Vamos a crear un nuevo Evento</h2>	
<form action="gestion?opcion=alta" method="post">
<p><input type="text" name="nombre">Nombre</p>
<p><input type="text" name="descripcion">Descripcion</p>
<p><input type="text" name="fechainicio">Fecha de inicio</p>
<p><input type="text" name="duracion">Duracion</p>
<p><input type="text" name="direccion">Direccion</p>
<p><input type="text" name="destacado">Destacado</p>
<p><input type="text" name="aforomaximo">Aforomaximo</p>
<p><input type="text" name="minimoasistencia">Minimo de asistencia</p>
<p><input type="text" name="precio">Precio</p>
<p><input type="text" name="idtipo">Id tipo</p>
<p><input type="submit" value="Enviar"></p>
</form>
</body>
</html>