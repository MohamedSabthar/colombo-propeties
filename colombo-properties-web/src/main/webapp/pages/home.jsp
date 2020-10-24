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
		<jsp:include page="../partials/header.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>
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
													<img width="250" height="210" src="/uploads/${image.image}"
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
												<li><strong>Address : </strong>${property.address}</li>
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



	<jsp:include page="../partials/footer.jsp">
    <jsp:param name="type" value="all"/>
</jsp:include>
</body>

</html>