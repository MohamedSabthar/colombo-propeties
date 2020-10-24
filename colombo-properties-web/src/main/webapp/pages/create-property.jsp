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

<link href="../css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="background-color: #f2f2f2;">

	<jsp:include page="../partials/header.jsp">
		<jsp:param name="type" value="admin" />
	</jsp:include>

	<div class="container rounded-lg border-0 "
		style="margin-top: 2%; margin-bottom: 5%; border: 1px solid; padding: 2%; background-color: white;">
		<div class="row">

			<div class="card col-7 border-0"
				style="padding: 0px; margin-top: auto;">
				<h4>Your past advertisements</h4>
				<c:if test="${empty properties}">
				No past advertisements
				</c:if>
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
												<li><strong>Land Size : </strong> ${property.landSize}</li>
												<li><strong>Property Size : </strong> ${property.propertySize}</li>
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
			<div class="col-1"></div>
			<div class="col-4">
				<h4>Create a new advertisements</h4>
				<form:form method="post" action="/property/create"
					modelAttribute="createProperty" ENCTYPE="multipart/form-data">


					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Title </label>
						<form:input path="title" id="inputState" class="form-control"
							type="text" />
					</div>




					<div class="form-group">
						<label for="inputState" class="font-weight-bold">
							Description </label>
						<form:textarea path="description" id="inputState"
							class="form-control" type="text" rows="10" />
					</div>



					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Address
						</label>
						<form:input path="address" id="inputState" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Land
							size </label>
						<form:input path="landSize" id="inputState" class="form-control"
							type="number" />
					</div>

					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Property
							size </label>
						<form:input path="propertySize" id="inputState"
							class="form-control" type="number" />
					</div>

					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Price </label>
						<form:input path="price" id="inputState" class="form-control"
							type="number" />
					</div>


					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Location
						</label>
						<form:select path="location" id="inputState" class="form-control">


							<c:forEach items="${locations}" var="location">

								<form:option value="${location.id}">${location.location}</form:option>

							</c:forEach>
						</form:select>
					</div>


					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Sale
							Type </label>
						<form:select path="saleType" id="inputState" class="form-control">

							<c:forEach items="${saleTypes}" var="saleType" varStatus="loop">

								<form:option value="${saleType.id}">${saleType.type}</form:option>

							</c:forEach>

						</form:select>
					</div>
					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Property
							Type </label>
						<form:select path="propertyType" id="inputState"
							class="form-control">

							<c:forEach items="${propertyTypes}" var="propertyType">

								<form:option value="${propertyType.id}">${propertyType.type}</form:option>

							</c:forEach>
						</form:select>
					</div>





					<form:input path="user" value="${user}" type="hidden" />










					<div class="form-group">
						<label for="inputState" class="font-weight-bold"> Upload
							Images </label> <input id="inputState" class="form-control" type="file"
							name="files" multiple />
					</div>



					<input type="submit" value="create"
						class="btn btn-warning btn-lg btn-block" />
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="../partials/footer.jsp">
		<jsp:param name="type" value="authors" />
	</jsp:include>
</body>
</html>