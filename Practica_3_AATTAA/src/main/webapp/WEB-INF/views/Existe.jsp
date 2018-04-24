<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
                    <%@include file="Formulario/css/style.css" %>	
		  			<%@include file="TablaExiste/css/util.css" %>	
		  			<%@include file="TablaExiste/css/main.css" %>
		  			<%@include file="TablaExiste/fonts/font-awesome-4.7.0/css/font-awesome.min.css" %>		  			
			</style>
 
  <title>EXISTE</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>
<body>
<br>
<br>
<h1>USUARIO ENCONTRADO</h1>
<br>
<br>
<br>
<br>
<div class="table100 ver3 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
								    <th class="cell100 column1">Nombre</th>
									<th class="cell100 column2">Primer Apellido</th>
									<th class="cell100 column3">Segundo Apellido</th>
									<th class="cell100 column4">DNI</th>
									<th class="cell100 column5">NICK</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
									<tr class="row100 body">
									<td class="cell100 column1">${nusuario.nombre}</td>
									<td class="cell100 column2">${nusuario.apellido1}</td>
									<td class="cell100 column3">${nusuario.apellido2}</td>
									<td class="cell100 column4">${nusuario.nif}</td>
									<td class="cell100 column5">${nusuario.nick}</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
</body>

</html>