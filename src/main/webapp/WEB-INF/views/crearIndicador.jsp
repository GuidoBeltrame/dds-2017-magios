<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>

<body style="padding-top:0px;">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="./menu">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownIndicadores" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Indicadores
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownIndicadores">
	          <a class="dropdown-item" href="./crearIndicador">Crear Indicadores</a>
	          <a class="dropdown-item" href="./indicadores">Ver Indicadores</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownCuentas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Cuentas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownCuentas">
	          <a class="dropdown-item" href="#">Ver Cuentas</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownMetodologias" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Metodologías
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownMetodologias">
	          <a class="dropdown-item" href="#">Crear Metodologías</a>
	          <a class="dropdown-item" href="#">Ver Metodologías</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownBalances" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Balances
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownBalances">
	          <a class="dropdown-item" href="#">Buscar Balances</a>
	        </div>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="container col-sm-4 col-md-4 col-lg-4">
		<h2>CREAR INDICADOR</h2>
		<form action="validarIndicador" method="post">
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
