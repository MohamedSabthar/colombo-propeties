<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="../css/signin.css" rel="stylesheet">
<title>Login</title>
</head>
<body class="text-center">
	<form:form class="form-signin" method="post" action="/login"
		modelAttribute="loginRequest">
		<img class="mb-4 align-slef-center" src="../img/Screenshot (297).png"
			alt="" width="300" height="80">
		<div class="form-controll">
			<label for="inputUsername" class="sr-only ">Username</label>
			<form:input type="text" id="inputUsername" class="form-control  m-1"
				path="username" placeholder="Username" />
		</div>
		<div class="form-controll">
			<label for="inputPassword" class="sr-only">Password</label>
			<form:input type="password" id="inputPassword"
				class="form-control m-1" placeholder="Password" path="password" />
		</div>
		<div class="mb-3 mt-2">
			<a class="text-warning" href="\register">Need to Register?</a>
		</div>
		<button class="btn btn-lg btn-warning btn-block" type="submit">Sign
			in</button>

	</form:form>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
</body>


</html>