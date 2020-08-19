<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wellcome to Colombo Properties</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>
	<table class="table">
		<c:if test="${not empty properties}">
			<tr>
				<th>#id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Address</th>
				<th>Land-size</th>
				<th>Property-size</th>
				<th>Price</th>
				<th>Selling Status</th>
				<th>Location/Area</th>
				<th>Sales-type</th>
				<th>Images</th>
				<th>User id</th>
				<th>Username</th>
				<th>Email</th>
				<th>Phone Number</th>
			</tr>
			<c:forEach items="${properties}" var="property">
				<tr>
					<td>${property.id}</td>
					<td>${property.title}</td>
					<td>${property.description}</td>
					<td>${property.address}</td>
					<td>${property.landSize}</td>
					<td>${property.propertySize}</td>
					<td><fmt:formatNumber value="${property.price}"
							type="currency" currencyCode="LKR" /></td>
					<td>${property.status==false ? "Available": "Sold"}</td>
					<td>${property.location.location}</td>
					<td>${property.saleType.type}</td>
					<td><c:if test="${not empty property.images}">
							<c:forEach items="${property.images}" var="image">
								<img width="200" height="200" src="${image.image}"
									alt="${property.title}" />
							</c:forEach>
						</c:if></td>
					<td>${property.user.id}</td>
					<td>${property.user.username}</td>
					<td>${property.user.email}</td>
					<td>${property.user.phone}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>