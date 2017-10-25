<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cuentas</title>
</head>

<body style="padding-top:0px;">

	<jsp:include page="_partialMenu.jsp" />
	
	<div class="container">
		<h2>Lista Cuentas</h2>
		<p>
	        <a class="nav-link" href="./crearCuenta">Crear Cuenta<span class="sr-only">(current)</span></a>
		</p>
		<table class="table">
		    <tr>
		        <th>Nombre</th>	
		        <th>Indentificador</th>
		    </tr>
		       
			<c:forEach var="list" items="${listaCuentas}">
				<tr>
			        <td>${list.nombre}</td>
			        <td>${list.identificador}</td>
            	</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>