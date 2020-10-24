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

	<div class="container"
		style="background-color: #f2f2f2; align-items: center;">
		<div class="card ad-card my-4"
			style="width: 65%; padding: 3%;; margin: auto;">
			<section class="mb-4">

				<!--Section heading-->
				<h2 class="h1-responsive font-weight-bold text-center my-4">Contact
					us</h2>
				<!--Section description-->
				<p class="text-center w-responsive mx-auto mb-5">Do you have any
					questions? Please do not hesitate to contact us directly. Our team
					will come back to you within a matter of hours to help you.</p>

				<div class="row">

					<!--Grid column-->
					<div class="col">
						<form:form method="post" action="/contact"
							modelAttribute="createContact">


							<!--Grid row-->
							<div class="row">

								<!--Grid column-->
								<div class="col-md-6">
									<div class="md-form mb-0">
										<label for="name" class="">Your name</label>
										<form:input type="text" id="name" name="name"
											class="form-control" path="name" />

									</div>
								</div>
								<!--Grid column-->

								<!--Grid column-->
								<div class="col-md-6">
									<div class="md-form mb-0">
										<label for="email" class="">Your email</label>
										<form:input path="email" type="text" id="email" name="email"
											class="form-control" />

									</div>
								</div>
								<!--Grid column-->

							</div>
							<!--Grid row-->

							<!--Grid row-->
							<div class="row">
								<div class="col-md-12">
									<div class="md-form mb-0">
										<label for="subject" class="">Subject</label>
										<form:input type="text" id="subject" name="subject"
											class="form-control" path="subject" />

									</div>
								</div>
							</div>
							<!--Grid row-->

							<!--Grid row-->
							<div class="row">

								<!--Grid column-->
								<div class="col-md-12">

									<div class="md-form">
										<label for="message">Your message</label>
										<form:textarea type="text" id="message" name="message"
											rows="2" path="message" class="form-control md-textarea" />

									</div>

								</div>
							</div>
							<!--Grid row-->

							<div class="text-center text-md-left mt-3">
								<input type="submit" value="submit"
									class="btn btn-info btn-block btn-warning" />
							</div>

						</form:form>
					</div>
				</div>
			</section>
		</div>
	</div>


	<jsp:include page="../partials/footer.jsp">
		<jsp:param name="type" value="all" />
	</jsp:include>

</body>
</html>
