<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Carga Cuentas</title>
</head>

<body style="padding-top:0px;">
	
	<jsp:include page="_partialMenu.jsp" />

	<div class="container col-sm-4 col-md-4 col-lg-4">
		<h2>PRECÁLCULO DE INDICADORES</h2>
		<form action="guardarProcesoCalculoIndicadores" method="post">
			<label for="error" class="alert-danger">${error}</label>
			<label for="ok" class="alert-warning">${ok}</label>
			<div class="form-group">
				<label for="anio">Período a Precalcular:</label>
				<select name="anio" id="anio" class="chosen-select-deselect form-control input-select" required>
					<option value="0">Seleccione Período</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Procesar</button>
			<button type="button" class="btn btn-outline-primary" onclick="closeCreate()">Cancelar</button>		
		</form>
	</div>
</body>

<script type="text/javascript">
	function closeCreate() {
		window.location.href = "./menu";
	}
		  
</script>

</html>
