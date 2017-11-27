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
		<h2>CARGA CUENTAS</h2>
		<form action="guardarProcesoCuentas" method="post">
			<label for="error" class="alert-danger">${error}</label>
			<label for="ok" class="alert-warning">${ok}</label>
			<div class="form-group">
				<label for="archivo" class="custom-file">
				  <input type="file" name="archivo" id="file" class="custom-file-input">
				  <span id="archivo" class="custom-file-control">Seleccione Archivo...</span>
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Cargar</button>
			<button type="button" class="btn btn-outline-primary" onclick="closeCreate()">Cancelar</button>		
		</form>
	</div>
</body>

<script type="text/javascript">
	function closeCreate() {
		window.location.href = "./menu";
	}
	
	$('.custom-file-input').on('change',function(){
		var fileName = $(this).val();
		
		$("#archivo")[0].textContent = fileName.split('\\')[2];
		$("#file")[0].textContent = fileName;
	});
		  
</script>

</html>
