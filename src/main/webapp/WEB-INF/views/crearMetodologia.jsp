<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Crear Metodología</title>
</head>

<body style="padding-top:0px;">
	
	<jsp:include page="_partialMenu.jsp" />

	<div class="container col-sm-4 col-md-4 col-lg-4">
		<h2>CREAR METODOLOGÍA</h2>
		<form action="validarMetodologia" method="post">
			<label for="error" class="alert-danger">${error}</label>
			<label for="ok" class="alert-warning">${ok}</label>
			<div class="form-group">
				<label for="nombre">Nombre:</label> 
				<input type="text" class="form-control" id="nombre" 
				 placeholder="Nombre" name="nombre" required>
			</div>
			<div class="form-group">
				<label for="formula">Fórmula:</label>
				<input type="text" class="form-control" id="formula" 
				 placeholder="Fórmula" name="formula" required>
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
</script>

</html>
