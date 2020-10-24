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


	<div class="container"
		style="background-color: #f2f2f2; align-items: center;">
		<div class="card ad-card my-4"
			style="width: 95%; padding: 3%;; margin: auto;">
			<section class="mb-4">

				<div class="row">

					<!--Grid column-->
					<div class="col text-center">
						<h4>Contact-us records</h4>

					</div>
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Subject</th>
								<th scope="col">Message</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${records}" var="record">
								<tr>
									<td>${record.name}</td>
									<td>${record.email}</td>
									<td>${record.subject}</td>
									<td>${record.message}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

			</section>
		</div>
	</div>

	<jsp:include page="../partials/footer.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>
</body>
</html>
