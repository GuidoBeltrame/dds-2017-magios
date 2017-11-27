<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Aplicar Metodología</title>
</head>

<body style="padding-top:0px;">
	
	<jsp:include page="_partialMenu.jsp" />

	<div class="container col-sm-4 col-md-4 col-lg-4">
		<h2>APLICAR METODOLOGÍA</h2>
		<form action="aplicacionMetodologia" method="post">
			<div class="form-group">
				<label for="metodologia">Metodología:</label> 
				<select name="metodologia" id="metodologia" class="chosen-select-deselect form-control input-select">
				    <option value="0">Seleccione Metodología</option>
				    <c:forEach var="list" items="${listaMetodologias}">				     
				        <option value="${list.idMetodologia}">${list.nombre}</option>
				    </c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="empresas">Empresa/s:</label>
				<select name="empresas" id="empresas" data-placeholder="Seleccione Empresa" multiple class="chosen-select-deselect form-control input-select">
					<option value="0">Todas</option>
					<c:forEach var="list" items="${listaEmpresas}">				     
				        <option value="${list.idEmpresa}">${list.nombre}</option>
				    </c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="anio">Período a Aplicar:</label>
				<select name="anio" id="anio" class="chosen-select-deselect form-control input-select">
					<option value="0">Seleccione Período</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<button type="button" class="btn btn-outline-primary" onclick="closeCreate()">Cancelar</button>		
		</form>
	</div>
</body>

<script type="text/javascript">
	function closeCreate() {
		window.location.href = "./menu";
	}
    $(function() {
      $('.chosen-select').chosen();
      $('.chosen-select-deselect').chosen({ allow_single_deselect: true });
    });
</script>
</html>
