<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>
<h1>Control de acceso</h1>
<form action="http://localhost:8080/DNIE/CompruebaBBDD" method=post>
Nombre:<input type="text" name="nombre"> DNI:<input type="text" name="nif">
<p>${yaExiste}</p>
<br>
<br>
<input type=submit value=Enviar>
</form>
</body>
</html>