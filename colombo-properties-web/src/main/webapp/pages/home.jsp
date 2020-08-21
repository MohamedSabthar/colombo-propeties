<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Colombo Properties</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="../css/style.css" rel="stylesheet">

</head>

<body style="background-color: #f2f2f2;">
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

	<div class="container rounded-lg border-0 "
		style="margin-top: 2%; margin-bottom: 5%; border: 1px solid; padding: 2%; background-color: white;">
		<div class="search-result">
			<h4>Showing All properites</h4>
		</div>
		<hr />
		<div class="row first-row">
			<div class="card col-8 border-0"
				style="padding: 0px; margin-top: auto;">
				<c:if test="${not empty properties}">
					<c:forEach items="${properties}" var="property">
						<div class="card " style="padding: 0px; margin-top: 1%;">
							<div class="card-body">
								<div class="row pr-lg-0">
									<div class="col-md-3 mb-2">
										<div class="Picture">
											<c:forEach items="${property.images}" var="image"
												varStatus="loop">
												<c:if test="${loop.first}">
													<img width="250" height="210" src="${image.image}"
														class="img-fluid rounded mb-0" alt="smaple image">
												</c:if>

											</c:forEach>

										</div>
									</div>
									<div class="col-md-9 mb-8 d-flex align-items-center">
										<div class="w-100">
											<div class="Title">
												<h3 class="font-weight-bold mb-4">
													<a href="/property/${property.id}">${property.title}</a>
												</h3>
											</div>
											<ul class="list-unstyled">
												<li><i class="fas fa-bed"></i> : 3 &emsp; <i
													class="fas fa-bath"> </i> : 2</li>
												<li><strong>Perches : </strong> 12.8</li>
												<li>No 08, Jawatta Road ,Colombo 07</li>
												<!-- <div>
									<a href="#" class=" btn btn-primary stretched-link float-left">View Property</a>
								</div> -->
											</ul>
											<div class="price " style="text-align: right;">
												<h2>
													<fmt:formatNumber value="${property.price}" type="currency"
														currencyCode="LKR" />
												</h2>
											</div>

										</div>

									</div>
								</div>
							</div>



						</div>
					</c:forEach>
				</c:if>


				<!-- ----------------------------------------------------------------------card end------------------------------------------------------------------------- -->

			</div>

			<div class="card col-1 border-0"></div>


			<div class="card-body">
				<form:form method="post" action="/property/filter"
					modelAttribute="filterPropertyRequest">
					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Sale
							Type</label>
						<form:select path="saleType" id="inputState" class="form-control">
							<option value="0" selected>All</option>
							<c:forEach items="${saleTypes}" var="saleType" varStatus="loop">

								<form:option value="${saleType.id}">${saleType.type}</form:option>

							</c:forEach>

						</form:select>
					</div>
					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Property
							Type</label>
						<form:select path="propertyType" id="inputState"
							class="form-control">
							<option selected value="0">All</option>
							<c:forEach items="${propertyTypes}" var="propertyType">

								<form:option value="${propertyType.id}">${propertyType.type}</form:option>

							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Location
						</label>
						<form:select path="location" id="inputState" class="form-control">
							<option value="0" selected>All</option>
							<c:forEach items="${locations}" var="location">

								<form:option value="${location.id}">${location.location}</form:option>

							</c:forEach>
						</form:select>
					</div>

					<input type="submit" value="submit"
						class="btn btn-warning btn-lg btn-block" />
				</form:form>
			</div>

		</div>
	</div>
	</div>





	<!-- Footer -->
	<footer class="page-footer font-small bg-warning">

		<!-- Footer Elements -->

		<!-- Copyright -->
		<div class=" footer-copyright py-4">
			<li class="copyright list-unstyled" style="text-align: center;">
				© 2020 Copyright : All Rights Reserved</li>
			<li class="team list-unstyled font-weight-bold"
				style="text-align: right;">Designed & Developed By Team123</li>
		</div>
		<!-- Team -->

	</footer>
	<!-- Footer -->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
</body>

</html>