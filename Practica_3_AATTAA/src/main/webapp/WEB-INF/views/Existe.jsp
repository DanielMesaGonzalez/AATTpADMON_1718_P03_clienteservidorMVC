<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="st" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
		  			<%@include file="Formulario/css/style.css" %>		  			
			</style>
<title>Sesion</title>
</head>
<body>
<h1>AUTENTICACIÓN CORRECTA</h1> 
Nombre:<st:out value="${nusuario.nombre}"/>
Apellido1:<st:out value="${nusuario.apellido1}"/>
Apellido2:<st:out value="${nusuario.apellido2}"/>
NIF:<st:out value="${nusuario.nif}"/>
<p>${nick}</p>
</body>
</html>