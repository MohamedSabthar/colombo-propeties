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

	<jsp:include page="../partials/header.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>

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

							<c:if test="${loop.first}">

							</c:if>
							<c:if test="${not loop.first}">
								<div class="carousel-item">
									<img src="/uploads/${image.image}" class="d-block w-100"
										alt="..." height="600px">
								</div>
							</c:if>
							<ol class="carousel-indicators">

								<c:forEach items="${property.images}" var="image"
									varStatus="loop">
									<c:if test="${loop.first}">
										<li data-target="#carouselExampleIndicators" data-slide-to="0"
											class="active"></li>

									</c:if>
									<c:if test="${not loop.first}">
										<li data-target="#carouselExampleIndicators"
											data-slide-to="loop"></li>

									</c:if>
								</c:forEach>



							</ol>
							<div class="carousel-inner">

								<c:forEach items="${property.images}" var="image"
									varStatus="loop">
									<c:if test="${loop.first}">
										<div class="carousel-item active">
											<img src="/uploads/${image.image}" class="d-block w-100"
												alt="..." height="600px">
										</div>

									</c:if>
									<c:if test="${not loop.first}">
										<div class="carousel-item">
											<img src="/uploads/${image.image}" class="d-block w-100"
												alt="..." height="600px">
										</div>
									</c:if>
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
									<div class="card-body ">
										${property.description}
										<ul class="list-unstyled mt-3">
											<li><strong>Land Size : </strong> ${property.landSize}</li>
											<li><strong>Property Size : </strong>
												${property.propertySize}</li>
											<li><strong>Address : </strong>${property.address}</li>

										</ul>

									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header bg-white" id="headingTwo">
									<h5 class="mb-0">
										<button class="btn btn-link" data-toggle="collapse"
											data-target="#collapseTwo" aria-expanded="true"
											aria-controls="collapseTwo">
											<h4>
												<i class="fa fa-chevron-down"></i> Address
											</h4>
										</button>
									</h5>
								</div>
								<div id="collapseTwo" class="collapse"
									aria-labelledby="headingTwo" data-parent="#accordion">

									<div id="collapseOne" class="collapse show"
										aria-labelledby="headingOne" data-parent="#accordion">
										<div class="card-body">

											<ul class="list-unstyled mt-3">
												<li><strong>Location : </strong>
													${property.location.location}</li>
												<li><strong>Address : </strong> ${property.address}</li>

											</ul>


										</div>
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
										<b>${property.user.username}</b>
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
								<div class="card card-body">${property.user.phone}</div>
							</div>
							<br>

							<button class="btn btn-danger btn-lg btn-block" type="button"
								data-toggle="collapse" data-target="#collapseExample2"
								aria-expanded="false" aria-controls="collapseExample2">
								<i class="fa fa-envelope"></i> Email
							</button>
							<div class="collapse" id="collapseExample2">
								<div class="card card-body">${property.user.email}</div>
							</div>
							<br>
							<%-- 	<button class="btn btn-primary btn-lg btn-block" type="button"
								data-toggle="collapse" data-target="#collapseExample3"
								aria-expanded="false" aria-controls="collapseExample3">
								Address</button>
							<div class="collapse" id="collapseExample3">
								<div class="card card-body">${property.address}
								</div>
							</div> --%>
						</div>


					</div>

				</div>


			</div>
		</div>

	</c:if>
	<jsp:include page="../partials/footer.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>

</body>
</html>
