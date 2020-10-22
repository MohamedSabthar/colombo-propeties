<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="../css/style.css" rel="stylesheet">
</head>
<body style="background-color: #f2f2f2;">


	<!-- Navigation -->

	<!-- Brand -->

	<header role="banner">
		<div class="container-fluid bg-white">
			<img src="../img/Screenshot (297).png" width="700">
		</div>


		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-warning "
			style="max-height: 75px;">


			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto" style="margin-left: 100px;">

					<li class="nav-item active" style="padding-right: 15px;"><a
						class="nav-link" href="#"><strong>Home</strong> <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item active" style="padding-right: 15px;"><a
						class="nav-link" href="#"><strong>About Us</strong> <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item active" style="padding-right: 15px;"><a
						class="nav-link" href="#"><strong>Contact</strong> <span
							class="sr-only">(current)</span></a></li>

				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2 " style="width: 250px;"
						type="search" placeholder="What are you looking for ?"
						aria-label="Search">
					<button class="btn btn-light" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>

				<ul class="navbar-nav col-auto">
					<li class="nav-item" style="padding-right: 60px;">
						<button type="button" class="btn btn-outline-dark">POST
							YOUR AD</button>
					</li>
				</ul>
				<ul class="navbar-nav" style="padding: 0px;">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <img src="../img/avatar-5.jpg"
							class="rounded-circle z-depth-0" alt="avatar image" height="50">
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Profile</a> <a
								class="dropdown-item" href="#">Sign out</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
				</ul>
			</div>
		</nav>
	</header>

	 success
	<jsp:include page="../partials/footer.jsp">
    <jsp:param name="type" value="all"/>
</jsp:include>
</body>
</html>
