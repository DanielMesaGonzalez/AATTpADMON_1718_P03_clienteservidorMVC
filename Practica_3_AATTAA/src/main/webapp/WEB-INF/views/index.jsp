<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
		  			<%@include file="Formulario/css/style.css" %>	
		  				  			
			</style>
 
  <title>Flat HTML5/CSS3 Login Form</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>
<title>Formulario</title>
<body>
<h1>Control de acceso</h1>

   <div class="form">
    <form action="http://localhost:8080/DNIE/CompruebaBBDD" class="login-form" method=post>
      <input type="text" name=nombre placeholder="Introduce tu nick"/>
      <input type="text" name=nif placeholder="Introduce tu DNI"/>
      <p>${yaExiste}</p>
      <br>
      <button>ENTRAR</button>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>




</body>

</html>