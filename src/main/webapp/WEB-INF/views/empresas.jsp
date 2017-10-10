<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Empresas</title>
</head>

<body style="padding-top:0px;">

	<jsp:include page="_partialMenu.jsp" />
	
	<div class="container">
		<h2>Lista Empresas</h2>
		<p>
	        <a class="nav-link" href="./crearEmpresa">Crear Empresa<span class="sr-only">(current)</span></a>
		</p>
		<table class="table">
		    <tr>
		        <th>Nombre</th>	
		    </tr>
		       
			<c:forEach var="list" items="${listaEmpresas}">
				<tr>
			        <td>${list.nombre}</td>
            	</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>