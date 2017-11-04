<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Reporte</title>
</head>

<body style="padding-top:0px;">

	<jsp:include page="_partialMenu.jsp" />
	
	<div class="container">
		<h2>Reportes</h2>
		<table class="table">
		    <tr>
		        <th>Empresa</th>
		        <th>Metodología</th>
		        <th>Período</th>
		        <th>Resultado</th>		
		    </tr>
		       
			<c:forEach var="list" items="${listaReporte}">
				<tr>
			        <td>${list.empresa}</td>
                	<td>${list.metodologia}</td>
                	<td>${list.periodo}</td>
                	<td>${list.resultado}</td>
            	</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>