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

	<!--- Cards -->
	<c:if test="${not empty property}">
		<div class="container rounded-lg border-0 "
			style="margin-top: 2%; margin-bottom: 5%; border: 1px solid; padding: 2%; background-color: white;">
			<div class="search-result" style="margin-left: 2%;">
				<h3>
					<b>${property.title } </b>
				</h3>
			</div>



			<div class="row first-row ">
				<div class="card img-carousal col-8 border-0">


					<div class="card img-carousal " style="margin: 2%;">
						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">

								<c:forEach items="${property.images}" var="image"
									varStatus="loop">
									<c:if test="${loop.first}">
										<div class="carousel-item active">
											<img src="${image.image}" class="d-block w-100" alt="..."
												height="600px">
										</div>

									</c:if>

									<div class="carousel-item">
										<img src="${image.image}" class="d-block w-100" alt="..."
											height="600px">
									</div>

								</c:forEach>




							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
					</div>

					<div class="card details" style="margin: 2%;">

						<div id="accordion border-0">
							<div class="card border-0">
								<div class="card-header bg-white" id="headingOne">
									<h5 class="mb-0">
										<button class="btn btn-link" data-toggle="collapse"
											data-target="#collapseOne" aria-expanded="true"
											aria-controls="collapseOne">
											<h4>
												<i class="fa fa-chevron-down"></i> Description
											</h4>
										</button>
									</h5>
								</div>

								<div id="collapseOne" class="collapse show"
									aria-labelledby="headingOne" data-parent="#accordion">
									<div class="card-body">${property.description}</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header bg-white" id="headingTwo">
									<h5 class="mb-0">
										<button class="btn btn-link" data-toggle="collapse"
											data-target="#collapseTwo" aria-expanded="true"
											aria-controls="collapseTwo">
											<h4>
												<i class="fa fa-chevron-down"></i> Details
											</h4>
										</button>
									</h5>
								</div>
								<div id="collapseTwo" class="collapse"
									aria-labelledby="headingTwo" data-parent="#accordion">
									<div class="card-body col-md-6 col-sm-6"
										style="padding-left: 5%;">
										<table width="90%">
											<tbody>
												<tr>
													<td class="left align-middle" width="35%">Property
														Type</td>
													<td class="right"><b>House</b></td>
												</tr>
												<tr>
													<td class="left align-middle" width="35%">Bedrooms</td>
													<td class="right"><b>3</b></td>
												</tr>
												<tr>
													<td class="left align-middle" width="35%">Bathrooms</td>
													<td class="right"><b>2</b></td>
												</tr>
												<tr>
													<td class="left align-middle" width="35%">Floor area</td>
													<td class="right"><b>3</b></td>
												</tr>
											</tbody>
										</table>
									</div>


								</div>
							</div>

						</div>

					</div>


				</div>

				<!-- contact -->

				<div class="card col-1 border-0"></div>

				<div class="card col-3 " style="margin-top: 10px;">

					<div class="card-header text-center bg-warning mt-2">
						<h4>
							<b>Contact Advertiser</b>
						</h4>
					</div>
					<div class="card-body">

						<div class="row" style="display: flex;">
							<div class="col-4" style="display: flex;">
								<img src="../img/avatar-5.jpg" width="100%" id=""
									class="rounded-circle" style="margin: auto;">
							</div>


							<div class="col-8 mb-3" style="display: flex; margin-top: 7%;">
								<span class="align-middle"><h5>
										<b>K.B Jessica</b>
									</h5></span>
							</div>
						</div>

						<div style="margin-top: 1%;">

							<button class="btn btn-success btn-lg btn-block" type="button"
								data-toggle="collapse" data-target="#collapseExample1"
								aria-expanded="false" aria-controls="collapseExample1">
								<i class="fas fa-phone fa-rotate-90"></i> Call
							</button>
							<div class="collapse" id="collapseExample1">
								<div class="card card-body">+94 77 8907 321</div>
							</div>
							<br>

							<button class="btn btn-danger btn-lg btn-block" type="button"
								data-toggle="collapse" data-target="#collapseExample2"
								aria-expanded="false" aria-controls="collapseExample2">
								<i class="fa fa-envelope"></i> Email
							</button>
							<div class="collapse" id="collapseExample2">
								<div class="card card-body">Jessica@mail.com</div>
							</div>
							<br>
							<button class="btn btn-primary btn-lg btn-block" type="button"
								data-toggle="collapse" data-target="#collapseExample3"
								aria-expanded="false" aria-controls="collapseExample3">
								Address</button>
							<div class="collapse" id="collapseExample3">
								<div class="card card-body">No 04, Jawatta Road Colombo 07
								</div>
							</div>
						</div>


					</div>

				</div>


			</div>
		</div>
	</c:if>
	<footer class="page-footer font-small bg-warning ">

		<!-- Footer Elements -->

		<!-- Copyright -->
		<div class=" footer-copyright py-4  ">
			<li class="copyright list-unstyled" style="text-align: center;">
				© 2020 Copyright : All Rights Reserved</li>
			<li class="team list-unstyled font-weight-bold"
				style="text-align: right;">Designed & Developed By Team123</li>
		</div>
		<!-- Team -->

	</footer>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

</body>
</html>
