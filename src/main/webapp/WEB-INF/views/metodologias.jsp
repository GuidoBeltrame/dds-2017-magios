<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Metodologías</title>
</head>

<body style="padding-top:0px;">

	<jsp:include page="_partialMenu.jsp" />
	
	<div class="container">
		<h2>Lista Metodologías</h2>
		<p>
	        <a class="nav-link" href="./crearMetodologia">Crear Metodología<span class="sr-only">(current)</span></a>
		</p>
		<table class="table">
		    <tr>
		        <th>Metodología</th>
		        <th>Valor / Fórmula</th>		
		    </tr>
		       
			<c:forEach var="list" items="${listaMetodologias}">
				<tr>
			        <td>${list.nombre}</td>
                	<td>${list.formula}</td>
            	</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>