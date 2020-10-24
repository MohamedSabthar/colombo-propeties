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
		<div class="col-8">
			<h4>Update advertisement</h4>
			<form:form method="post" action="/property/update/${id}" onsubmit="return confirm('Are you sure\n you neet edit details?');"
				modelAttribute="createProperty" ENCTYPE="multipart/form-data">


				<div class="form-group">
					<label for="inputState" class="font-weight-bold"> Title </label>
					<form:input path="title" id="inputState" class="form-control"
						type="text" />
				</div>
				<form:input path="id" id="id" class="form-control" type="hidden" />



				<div class="form-group">
					<label for="inputState" class="font-weight-bold">
						Description </label>
					<form:textarea path="description" id="inputState"
						class="form-control" type="text" rows="10" />
				</div>



				<div class="form-group">
					<label for="inputState" class="font-weight-bold"> Address </label>
					<form:input path="address" id="inputState" class="form-control"
						type="text" />
				</div>

				<div class="form-group">
					<label for="inputState" class="font-weight-bold"> Land size
					</label>
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
					<label for="inputState" class="font-weight-bold"> Sale Type
					</label>
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



				<input type="submit" value="Update"
					class="btn btn-warning btn-lg btn-block" />
			</form:form>
		</div>
	</div>




	<jsp:include page="../partials/footer.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>
</body>

</html>