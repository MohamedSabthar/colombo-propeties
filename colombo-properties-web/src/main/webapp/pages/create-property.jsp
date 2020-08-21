<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" action="/property/create"
		modelAttribute="createProperty" ENCTYPE="multipart/form-data">
		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Location </label> <input
				id="inputState" class="form-control" type="file" name="files"
				multiple />

		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Description
			</label>
			<form:input path="description" id="inputState" class="form-control"
				type="text" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Address </label>
			<form:input path="address" id="inputState" class="form-control"
				type="text" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Land size </label>
			<form:input path="landSize" id="inputState" class="form-control"
				type="number" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Property
				size </label>
			<form:input path="propertySize" id="inputState" class="form-control"
				type="number" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Price </label>
			<form:input path="price" id="inputState" class="form-control"
				type="number" />
		</div>


		<div class="form-group">
			<label for="inputState" class="font-weight-bold">
				PropertyType </label>
			<form:input path="propertyType" id="inputState" class="form-control"
				type="number" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Location </label>
			<form:input path="location" id="inputState" class="form-control"
				type="number" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> Sale Type </label>
			<form:input path="saleType" id="inputState" class="form-control"
				type="number" />
		</div>

		<div class="form-group">
			<label for="inputState" class="font-weight-bold"> user </label>
			<form:input path="user" value="1" id="inputState"
				class="form-control" type="number" />
		</div>






		<form:input path="title" type="text" />

		<input type="submit" value="Search"
			class="btn btn-warning btn-lg btn-block" />
	</form:form>
</body>
</html>