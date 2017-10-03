<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body style="padding-top:40px;">
	<div class="container col-sm-4 col-md-4 col-lg-4">
		<h2>LOGIN</h2>
		<form action="validarLogin" method="post">
			<label for="error" class="alert-danger">${error}</label>
			<div class="form-group">
				<label for="user">Usuario:</label> 
				<input type="text" class="form-control" id="user" 
				 placeholder="Usuario" name="user" required>
			</div>
			<div class="form-group">
				<label for="pass">Password:</label>
				<input type="password" class="form-control" id="pass" 
				 placeholder="Password" name="pass" required>
			</div>
<!-- 			<div class="checkbox"> -->
<!-- 				<label><input type="checkbox" name="remember"> -->
<!-- 					Recordar</label> -->
<!-- 			</div> -->
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</form>
	</div>
</body>
</html>