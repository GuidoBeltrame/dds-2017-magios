	<link rel="stylesheet" href="<%=request.getContextPath()%>/tether/css/tether.min.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-chosen.css" type="text/css">
	<script src="<%=request.getContextPath()%>/tether/js/tether.min.js"></script>
	<script src="<%=request.getContextPath()%>/jquery/jquery-3.2.1.slim.min.js"></script>
	<script src="<%=request.getContextPath()%>/popper/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/chosen.jquery.js"></script>
	
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
	          <a class="dropdown-item" href="./crearCuenta">Crear Cuenta</a>
	          <a class="dropdown-item" href="./cuentas">Ver Cuentas</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownEmpresas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Empresas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownEmpresas">
	          <a class="dropdown-item" href="./crearEmpresa">Crear Empresa</a>
	          <a class="dropdown-item" href="./empresas">Ver Empresas</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" id="dropDownMetodologias" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Metodologías
	        </a>
	        <div class="dropdown-menu" aria-labelledby="dropDownMetodologias">
	          <a class="dropdown-item" href="./crearMetodologia">Crear Metodología</a>
	          <a class="dropdown-item" href="./metodologias">Ver Metodologías</a>
	          <a class="dropdown-item" href="./aplicarMetodologia">Aplicar Metodología</a>
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